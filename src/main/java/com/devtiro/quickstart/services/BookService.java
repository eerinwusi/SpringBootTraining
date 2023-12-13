package com.devtiro.quickstart.services;

import com.devtiro.quickstart.domain.dto.BookDto;
import com.devtiro.quickstart.domain.entities.Book;

public interface BookService {
    Book createBook(Book book, String isbn);
}
