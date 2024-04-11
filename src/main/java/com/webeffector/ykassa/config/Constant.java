package com.webeffector.ykassa.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Constant {
    public static final String TYPE_PAY = "bank_card";
    public static final String CURRENCY_PAY = "RUB";
    public static final String IDEMPOTENCE_LABEL = "Idempotence-Key";
    public static final String CONFIRMATION_TYPE = "redirect";
}
