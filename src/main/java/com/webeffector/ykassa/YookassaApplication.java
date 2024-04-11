package com.webeffector.ykassa;

import com.webeffector.ykassa.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class YookassaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YookassaApplication.class, args);
    }

}
