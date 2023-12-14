package com.devtiro.quickstart.controllers;

import com.devtiro.quickstart.domain.dto.BookDto;
import com.devtiro.quickstart.domain.entities.Book;
import com.devtiro.quickstart.mappers.Mapper;
import com.devtiro.quickstart.mappers.impl.BookMapperImpl;
import com.devtiro.quickstart.services.BookService;
import com.sun.net.httpserver.HttpsServer;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private BookService bookService;

    private Mapper<Book, BookDto> mapper;

    public BookController(BookService bookService, Mapper<Book, BookDto> mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        Book book = mapper.mapFrom(bookDto);
        boolean bookExists = bookService.isExists(isbn);
        Book savedBook = bookService.createUpdateBook(book, isbn);
        BookDto savedDto = mapper.mapTo(savedBook);
        if (bookExists) {
            return new ResponseEntity<>(savedDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/books")
    public Page<BookDto> listBooks(Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        return books.map(mapper::mapTo);
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        Optional<Book> foundBook = bookService.findOne(isbn);
        return foundBook.map(book -> {
            BookDto bookDto = mapper.mapTo(book);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> partialUpdate(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        if (!bookService.isExists(isbn)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book book = mapper.mapFrom(bookDto);
        Book updatedBook = bookService.partialUpdate(isbn, book);
        return new ResponseEntity<>(mapper.mapTo(updatedBook), HttpStatus.OK);
    }

    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn) {
        bookService.delete(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
