package com.mateusHCandido.github.service;

import com.mateusHCandido.github.model.Book;
import com.mateusHCandido.github.proxy.ExchangeProxy;
import com.mateusHCandido.github.repository.BookRepository;
import com.mateusHCandido.github.service.dto.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ExchangeProxy exchangeProxy;

    public Book findBook(Long id, String currency) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        Exchange exchange = exchangeProxy.getExchange(book.getPrice(), "USD", currency);

        book.setCurrency(currency);
        book.setPrice(Objects.requireNonNull(exchange).getConvertedValue());
        book.setEnvironment(informationService.retrieveServerPort() + " FEIGN");

        return book;
    }
}
