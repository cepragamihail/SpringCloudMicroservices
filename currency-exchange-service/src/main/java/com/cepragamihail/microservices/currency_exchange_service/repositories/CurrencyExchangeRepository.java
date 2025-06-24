package com.cepragamihail.microservices.currency_exchange_service.repositories;

import com.cepragamihail.microservices.currency_exchange_service.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
