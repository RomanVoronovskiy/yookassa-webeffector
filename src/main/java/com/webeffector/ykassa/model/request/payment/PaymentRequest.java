package com.webeffector.ykassa.model.request.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "payment_info")
public class PaymentRequest {
    private Amount amount;

    @JsonProperty("payment_method_data")
    private PaymentMethodData paymentMethodData;

    private Confirmation confirmation;
    private String description;

    public PaymentRequest(String value, String currency, String type, String confirmationType, String returnUrl, String description) {
        this.amount = new Amount(value, currency);
        this.paymentMethodData = new PaymentMethodData(type);
        this.confirmation = new Confirmation(confirmationType, returnUrl);
        this.description = description;
    }
}
