package com.mateusHCandido.github.service;

import com.mateusHCandido.github.model.Exchange;
import com.mateusHCandido.github.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeService {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private ExchangeRepository exchangeRepository;

    public Exchange getExchange(BigDecimal amount, String from, String to){
        Exchange exchange = exchangeRepository.findByFromAndTo(from, to);

        if (exchange == null) throw new RuntimeException("currency Unsupported");

        BigDecimal conversionFactor = exchange.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);

        exchange.setConvertedValue(convertedValue);
        exchange.setEnvironment(informationService.retrieveServerPort());

        return exchange;
    }
}
