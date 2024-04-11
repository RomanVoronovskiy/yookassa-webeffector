package com.webeffector.ykassa.model.request.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Confirmation {
    private String type;

    @JsonProperty("return_url")
    private String returnUrl;
}
