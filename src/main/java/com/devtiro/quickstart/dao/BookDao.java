package com.devtiro.quickstart.dao;

import com.devtiro.quickstart.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
