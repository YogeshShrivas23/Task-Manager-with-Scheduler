package com.taskmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Profile("prod")
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @PostConstruct
    public void logDatabaseConfig() {
        log.info("Database URL: {}", databaseUrl);
        log.info("Database Username: {}", databaseUsername);
        // Don't log the password for security reasons
        log.info("Database configuration loaded successfully");
    }
} 