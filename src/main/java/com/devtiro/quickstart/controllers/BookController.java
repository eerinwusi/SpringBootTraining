package com.devtiro.quickstart.controllers;

import com.devtiro.quickstart.domain.dto.BookDto;
import com.devtiro.quickstart.domain.entities.Book;
import com.devtiro.quickstart.mappers.Mapper;
import com.devtiro.quickstart.mappers.impl.BookMapperImpl;
import com.devtiro.quickstart.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private BookService bookService;

    private Mapper<Book, BookDto> mapper;

    public BookController(BookService bookService, Mapper<Book, BookDto> mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        Book book = mapper.mapFrom(bookDto);
        Book savedBook = bookService.createBook(book, isbn);
        BookDto savedDto = mapper.mapTo(savedBook);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }
}