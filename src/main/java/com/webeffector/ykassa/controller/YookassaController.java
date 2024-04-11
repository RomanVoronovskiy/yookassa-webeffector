package com.webeffector.ykassa.controller;

import com.webeffector.ykassa.model.request.notification.PaymentNotification;
import com.webeffector.ykassa.model.request.payment.UserRequest;
import com.webeffector.ykassa.model.response.UrlConfirmation;
import com.webeffector.ykassa.service.YookassaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("yookassa/v1")
@Tag(name = "Основное АПИ по ТЗ")
@RequiredArgsConstructor
public class YookassaController {

    private final YookassaService yookassaService;

    @Operation(summary = "Метода создания платежа", description = "Создаем платеж согласно документации: https://yookassa.ru/developers/api#create_payment")
    @ApiResponse(responseCode = "200", description = "Успешное создание платежа", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "500", description = "Другая/неожиданная ошибка сервера", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @PostMapping("/create")
    public ResponseEntity<UrlConfirmation> createPayment(@RequestBody UserRequest request) {
        return yookassaService.createPayment(request);
    }

    @Operation(summary = "Метод информации о статусах", description = "Эндпоинт предназначен для получения информации о изменении статусов созданных платежей")
    @ApiResponse(responseCode = "200", description = "Успешное получение статусов", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "500", description = "Другая/неожиданная ошибка сервера", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/status")
    public ResponseEntity<String> statusInfo(@RequestBody PaymentNotification paymentNotification) {
        return yookassaService.saveStatusInfo(paymentNotification);
    }
}
