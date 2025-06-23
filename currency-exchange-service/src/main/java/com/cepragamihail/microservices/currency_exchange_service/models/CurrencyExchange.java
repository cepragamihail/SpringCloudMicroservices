package com.cepragamihail.microservices.currency_exchange_service.models;

import java.math.BigDecimal;

public class CurrencyExchange {
    private Long id;
    private String from;
    private String to;
    private BigDecimal rate;
    private String environmentPort;

    public CurrencyExchange() {}

    public CurrencyExchange(Long id, String from, String to, BigDecimal rate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getEnvironmentPort() {
        return environmentPort;
    }

    public void setEnvironmentPort(String environmentPort) {
        this.environmentPort = environmentPort;
    }
}
