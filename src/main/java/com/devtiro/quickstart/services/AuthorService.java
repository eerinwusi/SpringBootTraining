package com.devtiro.quickstart.services;

import com.devtiro.quickstart.domain.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author author);

    List<Author> findAll();

    Optional<Author> findOne(Long id);
}
