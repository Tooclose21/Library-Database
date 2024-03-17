package com.example.technologiesieciowe.repository;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.BookDetails;
import org.springframework.data.repository.CrudRepository;

public interface BookDetailsRepository extends CrudRepository<BookDetails, Integer> {
}
