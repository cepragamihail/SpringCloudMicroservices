package com.cepragamihail.microservices.currency_conversion_service.proxies;

import com.cepragamihail.microservices.currency_conversion_service.models.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getCurrencyConversionRate(@PathVariable String from, @PathVariable String to);
}
