package com.cepragamihail.microservices.limits_service.controller;

import com.cepragamihail.microservices.limits_service.configuration.Configuration;
import com.cepragamihail.microservices.limits_service.models.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {


    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits limits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }


}

