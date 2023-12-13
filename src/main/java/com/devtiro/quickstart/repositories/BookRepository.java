package com.devtiro.quickstart.repositories;

import com.devtiro.quickstart.domain.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
