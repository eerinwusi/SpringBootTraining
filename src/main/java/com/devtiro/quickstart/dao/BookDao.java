package com.devtiro.quickstart.dao;

import com.devtiro.quickstart.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);

    List<Book> find();

    void update(String isbn, Book book);

    Optional<Book> findOne(String isbn);
}
