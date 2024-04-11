package com.webeffector.ykassa.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${app.swagger-server}")
    private String server;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Микросервис для работы с платежной системой")
                        .description("Рассматривается сервис Юкасса и взаимодействие с ним")
                        .version("v1.0.0")
                        .license(new License().name("OpenAPI 3").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Техническое задание от Максима Гордеева (webeffector.ru)")
                        .url("https://github.com/RomanVoronovskiy/yookassa-webeffector/blob/master/Readme.md"))
                .addServersItem(new Server().url(server));
    }

}
