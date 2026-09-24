package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Integration tests for Spring Boot REST API
 * Tests the REST endpoints without starting a server
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApplicationContextLoads() {
        // Test that the Spring Boot application starts successfully
        assert true;
    }

    @Test
    public void testWelcomeEndpoint() throws Exception {
        mockMvc.perform(get("/api/welcome"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists());
    }

    @Test
    public void testInfoEndpoint() throws Exception {
        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.appName").exists())
                .andExpect(jsonPath("$.version").exists())
                .andExpect(jsonPath("$.system").exists())
                .andExpect(jsonPath("$.runtime").exists());
    }

    @Test
    public void testGreetEndpoint() throws Exception {
        mockMvc.perform(get("/api/greet?name=TestUser"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, TestUser!"));
    }

    @Test
    public void testGreetEndpointWithDefaultName() throws Exception {
        mockMvc.perform(get("/api/greet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, World!"));
    }

    @Test
    public void testCalculateEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculate?a=10&b=5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.addition").value(15))
                .andExpect(jsonPath("$.subtraction").value(5))
                .andExpect(jsonPath("$.multiplication").value(50))
                .andExpect(jsonPath("$.division").value(2.0));
    }

    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").exists());
    }
}
