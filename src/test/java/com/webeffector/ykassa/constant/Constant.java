package com.webeffector.ykassa.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Constant {
    public static final String TEST_TEMPLATE_STATUS_INFO="\n" +
            "{\n" +
            "  \"type\": \"notification\",\n" +
            "  \"event\": \"payment.waiting_for_capture\",\n" +
            "  \"object\": {\n" +
            "    \"id\": \"22d6d597-000f-5000-9000-145f6df21d6f\",\n" +
            "    \"status\": \"waiting_for_capture\",\n" +
            "    \"paid\": true,\n" +
            "    \"amount\": {\n" +
            "      \"value\": \"2.00\",\n" +
            "      \"currency\": \"RUB\"\n" +
            "    },\n" +
            "    \"authorization_details\": {\n" +
            "      \"rrn\": \"10000000000\",\n" +
            "      \"auth_code\": \"000000\",\n" +
            "      \"three_d_secure\": {\n" +
            "        \"applied\": true\n" +
            "      }\n" +
            "    },\n" +
            "    \"created_at\": \"2018-07-10T14:27:54.691Z\",\n" +
            "    \"description\": \"Заказ №72\",\n" +
            "    \"expires_at\": \"2018-07-17T14:28:32.484Z\",\n" +
            "    \"metadata\": {},\n" +
            "    \"payment_method\": {\n" +
            "      \"type\": \"bank_card\",\n" +
            "      \"id\": \"22d6d597-000f-5000-9000-145f6df21d6f\",\n" +
            "      \"saved\": false,\n" +
            "      \"card\": {\n" +
            "        \"first6\": \"555555\",\n" +
            "        \"last4\": \"4444\",\n" +
            "        \"expiry_month\": \"07\",\n" +
            "        \"expiry_year\": \"2021\",\n" +
            "        \"card_type\": \"MasterCard\",\n" +
            "      \"issuer_country\": \"RU\",\n" +
            "      \"issuer_name\": \"Sberbank\"\n" +
            "      },\n" +
            "      \"title\": \"Bank card *4444\"\n" +
            "    },\n" +
            "    \"refundable\": false,\n" +
            "    \"test\": false\n" +
            "  }\n" +
            "}\n";
}
