package com.webeffector.ykassa.model.request.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequest {
    private Double amount;
    private String description;
}
