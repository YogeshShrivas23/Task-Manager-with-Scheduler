package com.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskManagerApplication {
    public static void main(String[] args) {
        // Set default profile to prod if not specified
        if (System.getenv("SPRING_PROFILES_ACTIVE") == null) {
            System.setProperty("spring.profiles.active", "prod");
        }
        SpringApplication.run(TaskManagerApplication.class, args);
    }
} 