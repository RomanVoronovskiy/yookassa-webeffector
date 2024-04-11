package com.webeffector.ykassa.service;

import com.webeffector.ykassa.config.ApplicationProperties;
import com.webeffector.ykassa.model.request.notification.PaymentNotification;
import com.webeffector.ykassa.model.request.payment.PaymentRequest;
import com.webeffector.ykassa.model.request.payment.UserRequest;
import com.webeffector.ykassa.model.response.PaymentCreateResponse;
import com.webeffector.ykassa.model.response.UrlConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static com.webeffector.ykassa.config.Constant.*;

@Service
@Transactional
@RequiredArgsConstructor
public class YookassaService {

    private final ApplicationProperties props;
    private final RestTemplate restTemplate;
    private final MongoTemplate mongoTemplate;

    @SneakyThrows
    public ResponseEntity<UrlConfirmation> createPayment(UserRequest request) {
        ResponseEntity<PaymentCreateResponse> responseEntity = restTemplate.postForEntity(
                props.getYookassaCreateUrl(),
                new HttpEntity<>(
                        new PaymentRequest(request.getAmount().toString(),
                                CURRENCY_PAY,
                                TYPE_PAY,
                                CONFIRMATION_TYPE,
                                props.getReturnUrl(),
                                request.getDescription()),
                        buildDefaultHeaders()
                ), PaymentCreateResponse.class);
        mongoTemplate.save(responseEntity.getBody());
        return ResponseEntity.ok(new UrlConfirmation(responseEntity.getBody().getConfirmation().getConfirmationUrl()));
    }


    public ResponseEntity<String> saveStatusInfo(PaymentNotification paymentNotification) {
        mongoTemplate.save(paymentNotification);
        return ResponseEntity.ok(buildStatusDescription(paymentNotification.getObject()));
    }

    /**
     * @param paymentObject объект с основными полями
     * @return транскрипция статуса
     * @apiNote метод предназначен для возврата пользователю читаемого статуса на RU языке
     */
    private String buildStatusDescription(PaymentNotification.PaymentObject paymentObject) {
        String status = paymentObject.getStatus();
        return switch (status) {
            case "pending" -> "Статус: ожидание";
            case "succeeded" -> "Статус: успешный платеж";
            case "waiting_for_capture" -> "Статус: платеж оплачен, деньги авторизованы и ожидают списания";
            case "canceled" -> "Статус: платеж отменен";
            default -> "Неизвестный статус";
        };
    }

    /**
     * @return Headers
     * @apiNote ютильный метод для создания базовых хидеров
     */
    private HttpHeaders buildDefaultHeaders() {
        return new HttpHeaders() {{
            setBasicAuth(props.getIdMagazineYookassa(), props.getApiKeyYookassa());
            set(IDEMPOTENCE_LABEL, String.valueOf(UUID.randomUUID()));
            setContentType(MediaType.APPLICATION_JSON);
        }};
    }

}
