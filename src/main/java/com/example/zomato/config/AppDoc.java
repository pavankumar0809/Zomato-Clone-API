package com.example.zomato.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppDoc {

    Info info() {
        return new Info()
                .title("Zomato-Clone-Application")
                .description("Zomato clone application is a RESTful webServices which we are cloning the Zomato APP")
                .version("v1");
    }

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(info());
    }
}
