package com.bankapp.webapi.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Banka Uygulaması API")
                        .version("1.0.0")
                        .description("Spring Boot ile geliştirilmiş kurumsal mimari bankacılık uygulaması")
                        .contact(new Contact()
                                .name("Banka API Ekibi")
                                .email("api@bankapp.com")));
    }
} 