package com.devtiro.quickstart.services.impl;

import com.devtiro.quickstart.domain.dto.BookDto;
import com.devtiro.quickstart.domain.entities.Book;
import com.devtiro.quickstart.repositories.BookRepository;
import com.devtiro.quickstart.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book, String isbn) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
