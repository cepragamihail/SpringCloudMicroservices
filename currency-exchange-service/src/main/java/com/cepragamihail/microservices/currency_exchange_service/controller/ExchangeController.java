package com.cepragamihail.microservices.currency_exchange_service.controller;

import com.cepragamihail.microservices.currency_exchange_service.entities.CurrencyExchange;
import com.cepragamihail.microservices.currency_exchange_service.repositories.CurrencyExchangeRepository;
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
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public ExchangeController(Environment environment,  CurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        final String environmentPort = environment.getProperty("local.server.port");
        final CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find exchange for " + from + " and " + to);
        }
        currencyExchange.setEnvironmentPort(environmentPort);
        return currencyExchange;
    }
}
