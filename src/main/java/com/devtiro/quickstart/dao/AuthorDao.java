package com.devtiro.quickstart.dao;

import com.devtiro.quickstart.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();
}
