package com.webeffector.ykassa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "app", ignoreInvalidFields = true)
public class ApplicationProperties {
    private String apiKeyYookassa;
    private String idMagazineYookassa;
    private String yookassaCreateUrl;
    private String returnUrl;
    private String dbName;
    private String dbHost;
    private Integer dbPort;

    @Value("${spring.data.mongodb.username}")
    private String dbLogin;

    @Value("${spring.data.mongodb.password}")
    private String dbPass;

}
