package com.cepragamihail.microservices.currency_exchange_service.controller;

import com.cepragamihail.microservices.currency_exchange_service.models.CurrencyExchange;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
public class ExchangeController {

    private final Environment environment;

    public ExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        String environmentPort = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.valueOf(50));
        currencyExchange.setEnvironmentPort(environmentPort);
        return currencyExchange;
    }
}
