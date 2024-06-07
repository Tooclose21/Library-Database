package com.example.technologiesieciowe.repository;

import com.example.technologiesieciowe.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findByIsbn(String isbn);
    Book findByTitle(String title);

}
