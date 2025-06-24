package com.cepragamihail.microservices.currency_exchange_service.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/circuit-breaker")
    @Retry(name = "sample-api", fallbackMethod = "fallbackResponseExample")
    public String circuitBreaker() {
        logger.info("====================> Circuit breaker started <===========================");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8765/test-enpoint/", String.class);
        return responseEntity.getBody();
    }

    public String fallbackResponseExample(Exception exception) {
        return "fallback response";
    }
}
