package com.example.technologiesieciowe.repository;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
