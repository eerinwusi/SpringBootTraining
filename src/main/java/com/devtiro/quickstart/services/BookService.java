package com.devtiro.quickstart.services;

import com.devtiro.quickstart.domain.dto.BookDto;
import com.devtiro.quickstart.domain.entities.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book, String isbn);

    List<Book> findAll();
}
