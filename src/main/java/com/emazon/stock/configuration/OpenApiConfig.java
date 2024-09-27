package com.emazon.stock.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${app.description}") String description,
            @Value("${app.title}") String title,
            @Value("${app.version}") String version
    ) {
        return new OpenAPI()
                .info(new Info().title(title).version(version).description(description))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth", Collections.singletonList("read")));
    }
}
