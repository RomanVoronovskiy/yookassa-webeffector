package com.webeffector.ykassa.controller;

import com.webeffector.ykassa.YookassaApplicationTests;
import com.webeffector.ykassa.model.request.notification.PaymentNotification;
import com.webeffector.ykassa.model.request.payment.UserRequest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static com.webeffector.ykassa.constant.Constant.TEST_TEMPLATE_STATUS_INFO;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class YookassaControllerTest extends YookassaApplicationTests {
    private static final String urlTemplate = "/yookassa/v1";


    @SneakyThrows
    @DisplayName("тест на создание платежа")
    @Test
    void createPayment() {
        UserRequest createRequest = UserRequest.builder()
                .amount(12.0)
                .description("тест тестовый")
                .build();
        String body = getMapper().writeValueAsString(createRequest);
        mockMvc.perform(post(urlTemplate + "/create")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.url", is(notNullValue())));
    }

    @SneakyThrows
    @DisplayName("тест на получение инфо по статусу")
    @Test
    void statusInfo() {
        PaymentNotification createRequest = getMapper().readValue(TEST_TEMPLATE_STATUS_INFO, PaymentNotification.class);
        String body = getMapper().writeValueAsString(createRequest);
        mockMvc.perform(get(urlTemplate + "/status")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", is(notNullValue())));
    }


}