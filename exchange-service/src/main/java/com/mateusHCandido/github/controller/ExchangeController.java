package com.mateusHCandido.github.controller;

import com.mateusHCandido.github.model.Exchange;
import com.mateusHCandido.github.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange-service")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchange(@PathVariable("amount") BigDecimal amount,
                                @PathVariable("from") String from,
                                @PathVariable("to") String to){
        return exchangeService.getExchange(amount, from, to);
    }
}
