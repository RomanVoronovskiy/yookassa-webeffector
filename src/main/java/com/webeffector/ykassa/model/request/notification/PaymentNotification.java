package com.webeffector.ykassa.model.request.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "status_info")
public class PaymentNotification {
    @Id
    private long id;

    private String type;
    private String event;
    private PaymentObject object;

    @Data
    public static class PaymentObject {
        private String id;
        private String status;
        private boolean paid;
        private Amount amount;
        private AuthorizationDetails authorizationDetails;
        private String created_at;
        private String description;
        private String expires_at;
        private Map<String, Object> metadata;
        private PaymentMethod paymentMethod;
        private boolean refundable;
        private boolean test;

        @Data
        static class Amount {
            private String value;
            private String currency;
        }

        @Data
        static class AuthorizationDetails {
            private String rrn;
            @JsonProperty("auth_code")
            private String authCode;
            private ThreeDSecure three_d_secure;

            @Data
            static class ThreeDSecure {
                private boolean applied;
            }
        }

        @Data
        static class PaymentMethod {
            private String type;
            private String id;
            private boolean saved;
            private Card card;
            private String title;

            @Data
            static class Card {
                @JsonProperty("first6")
                private String first6;
                @JsonProperty("last4")
                private String last4;
                @JsonProperty("expiry_month")
                private String expiryMonth;
                @JsonProperty("expiry_year")
                private String expiryYear;
                @JsonProperty("card_type")
                private String cardType;
                @JsonProperty("issuer_country")
                private String issuerCountry;
                @JsonProperty("issuer_name")
                private String issuerName;
            }
        }
    }
}