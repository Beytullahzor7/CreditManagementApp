package com.bankapp.webapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.bankapp.*")
@EntityScan("com.bankapp.entities")
@EnableJpaRepositories("com.bankapp.repositories")
@OpenAPIDefinition(
    info = @Info(
        title = "Bank Credit Application API",
        version = "1.0.0",
        description = "REST API for Bank Credit Application"
    )
)
public class BankWebApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankWebApiApplication.class, args);
    }
} 