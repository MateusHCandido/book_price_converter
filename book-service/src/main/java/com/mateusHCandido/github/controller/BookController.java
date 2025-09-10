package com.mateusHCandido.github.controller;

import com.mateusHCandido.github.model.Book;
import com.mateusHCandido.github.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Endpoints")
@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = "/{id}/{currency}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ){
        return bookService.findBook(id, currency);
    }
}
