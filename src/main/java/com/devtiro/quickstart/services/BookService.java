package com.devtiro.quickstart.services;

import com.devtiro.quickstart.domain.dto.BookDto;
import com.devtiro.quickstart.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book, String isbn);

    List<Book> findAll();

    Optional<Book> findOne(String isbn);
}
