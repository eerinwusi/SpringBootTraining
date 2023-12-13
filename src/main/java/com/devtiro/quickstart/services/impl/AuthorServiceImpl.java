package com.devtiro.quickstart.services.impl;

import com.devtiro.quickstart.domain.entities.Author;
import com.devtiro.quickstart.repositories.AuthorRepository;
import com.devtiro.quickstart.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
