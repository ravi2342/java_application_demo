package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application - REST API for Maven and DevOps teaching
 * 
 * Run with: java -jar java-demo-app-1.0.0.jar
 * Access API at: http://localhost:8080
 * 
 * Key Endpoints:
 * - GET /api/info - System and application information
 * - GET /api/greet?name=YourName - Personalized greeting
 * - GET /actuator/health - Health check (for DevOps monitoring)
 * - GET /actuator - All actuator endpoints
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
