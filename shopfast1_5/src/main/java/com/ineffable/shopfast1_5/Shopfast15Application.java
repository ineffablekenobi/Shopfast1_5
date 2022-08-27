package com.ineffable.shopfast1_5;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@OpenAPIDefinition

public class Shopfast15Application {

    public static void main(String[] args) {
        SpringApplication.run(Shopfast15Application.class, args);
    }

}
