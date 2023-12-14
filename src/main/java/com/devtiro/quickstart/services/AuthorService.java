package com.devtiro.quickstart.services;

import com.devtiro.quickstart.domain.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);

    List<Author> findAll();

    Optional<Author> findOne(Long id);

    boolean isExists(Long id);
}
