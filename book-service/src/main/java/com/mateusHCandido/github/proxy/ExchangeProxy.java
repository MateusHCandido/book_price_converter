package com.mateusHCandido.github.proxy;

import com.mateusHCandido.github.service.dto.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "exchange-service")
public interface ExchangeProxy {


    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    public Exchange getExchange(@PathVariable("amount") BigDecimal amount,
                                @PathVariable("from") String from,
                                @PathVariable("to") String to);
}
