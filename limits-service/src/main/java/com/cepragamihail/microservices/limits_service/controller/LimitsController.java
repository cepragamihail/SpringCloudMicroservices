package com.cepragamihail.microservices.limits_service.controller;

import com.cepragamihail.microservices.limits_service.models.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @GetMapping("/limits")
    public Limits limits() {
        return new Limits(1, 1000);
    }


}
