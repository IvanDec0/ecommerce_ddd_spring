package com.ecommerce_learning.ecommerce_learning.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Value("${server.port}")
    private String port;


    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI();

        openAPI.addSecurityItem(new SecurityRequirement().
                addList("Bearer Authentication"));
        openAPI.setServers(Arrays.asList(
                new Server().url("http://localhost:" + port), // URL for local development
                new Server().url("https://google.com") // URL for production
        ));
        openAPI.components(new Components().addSecuritySchemes
                ("Bearer Authentication", createAPIKeyScheme()));
        return openAPI;
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
