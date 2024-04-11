package com.webeffector.ykassa.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "payment_info")
public class PaymentCreateResponse {
    private String id;
    private String status;
    private Amount amount;
    private String description;
    private Recipient recipient;
    private PaymentMethod paymentMethod;
    @JsonProperty("created_at")
    private String createdAt;
    private Confirmation confirmation;
    private boolean test;
    private boolean paid;
    private boolean refundable;
    private Map<String, Object> metadata;

    @Data
    @NoArgsConstructor
    public static class Amount {
        private String value;
        private String currency;
    }

    @Data
    @NoArgsConstructor
    public static class Recipient {
        @JsonProperty("account_id")
        private String accountId;
        @JsonProperty("gateway_id")
        private String gatewayId;
    }

    @Data
    @NoArgsConstructor
    public static class PaymentMethod {
        private String type;
        private String id;
        private boolean saved;
    }

    @Data
    @NoArgsConstructor
    public static class Confirmation {
        private String type;
        @JsonProperty("return_url")
        private String returnUrl;
        @JsonProperty("confirmation_url")
        private String confirmationUrl;
    }
}
