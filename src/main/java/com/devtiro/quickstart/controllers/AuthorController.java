package com.devtiro.quickstart.controllers;

import com.devtiro.quickstart.domain.dto.AuthorDto;
import com.devtiro.quickstart.domain.entities.Author;
import com.devtiro.quickstart.mappers.Mapper;
import com.devtiro.quickstart.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;

    private Mapper<Author, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<Author, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        Author author = authorMapper.mapFrom(authorDto);
        Author savedEntity = authorService.createAuthor(author);
        return new ResponseEntity<>(authorMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }
}
