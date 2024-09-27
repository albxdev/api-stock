package com.emazon.stock.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.emazon.stock")
@Getter
public class AppConfig {

    @Value("${app.description}")
    private String description;

    @Value("${app.title}")
    private String title;

    @Value("${app.version}")
    private String version;
}
