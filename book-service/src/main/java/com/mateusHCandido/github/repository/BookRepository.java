package com.mateusHCandido.github.repository;

import com.mateusHCandido.github.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
