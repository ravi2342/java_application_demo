package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for application information and demo endpoints
 * Accessible at: http://localhost:9090/api/
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @Value("${spring.application.name:Java Demo App}")
    private String appName;

    /**
     * GET /api/info - Returns system and application information
     * Great for DevOps monitoring and debugging
     */
    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        
        // Application info
        info.put("appName", appName);
        info.put("version", "1.0.0");
        info.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        // System info
        Map<String, String> system = new HashMap<>();
        system.put("javaVersion", System.getProperty("java.version"));
        system.put("javaVendor", System.getProperty("java.vendor"));
        system.put("osName", System.getProperty("os.name"));
        system.put("osVersion", System.getProperty("os.version"));
        system.put("osArch", System.getProperty("os.arch"));
        system.put("userHome", System.getProperty("user.home"));
        info.put("system", system);
        
        // Runtime info
        Map<String, Object> runtime = new HashMap<>();
        runtime.put("totalMemory", Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        runtime.put("freeMemory", Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");
        runtime.put("maxMemory", Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        runtime.put("processorCount", Runtime.getRuntime().availableProcessors());
        info.put("runtime", runtime);
        
        // Maven/Build info
        Map<String, String> build = new HashMap<>();
        build.put("buildTool", "Maven");
        build.put("framework", "Spring Boot");
        build.put("type", "REST API");
        build.put("packaging", "JAR");
        build.put("manifestStatus", "✓ Configured with Main-Class");
        info.put("build", build);
        
        return info;
    }

    /**
     * GET /api/greet?name=John - Personalized greeting
     * Demonstrates query parameters
     */
    @GetMapping("/greet")
    public Map<String, String> greet(@RequestParam(defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "!");
        response.put("status", "Success");
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return response;
    }

    /**
     * GET /api/calculate - Simple calculation endpoint
     * Demonstrates endpoint with query parameters
     */
    @GetMapping("/calculate")
    public Map<String, Object> calculate(
            @RequestParam(defaultValue = "5") int a,
            @RequestParam(defaultValue = "3") int b) {
        Map<String, Object> result = new HashMap<>();
        result.put("num1", a);
        result.put("num2", b);
        result.put("addition", a + b);
        result.put("subtraction", a - b);
        result.put("multiplication", a * b);
        result.put("division", b != 0 ? (double) a / b : "Cannot divide by zero");
        return result;
    }

    /**
     * GET /api/welcome - Welcome endpoint
     * Good for testing if the app is running
     */
    @GetMapping("/welcome")
    public Map<String, String> welcome() {
        Map<String, String> welcome = new HashMap<>();
        welcome.put("title", "Welcome to Spring Boot REST API");
        welcome.put("message", "This is a Java application built with Spring Boot and Maven");
        welcome.put("features", "REST API, DevOps ready, Containerizable");
        welcome.put("endpoints", "Visit http://localhost:9090/api/info for more details");
        return welcome;
    }
}
