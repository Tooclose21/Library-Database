package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.ReviewDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.dto.mappers.ReviewMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.Review;
import com.example.technologiesieciowe.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

/**
 * The type Review controller.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/review")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    /**
     * Instantiates a new Review controller.
     *
     * @param reviewRepository the review repository
     */
    @Autowired

    public ReviewController(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    /**
     * Add review review dto.
     *
     * @param review the review
     * @return the review dto
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody ReviewDto addReview(@RequestBody ReviewDto review){
        try {
            Review entity = reviewRepository.save(ReviewMapper.fromDto(review));
            return ReviewMapper.toDto(entity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot add a review");
        }
        //return reviewRepository.save(review);
    }

    /**
     * Get all reviews iterable.
     *
     * @return the iterable
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<ReviewDto> getAllReviews(){
        return StreamSupport.stream(reviewRepository.findAll().spliterator(),false).map(ReviewMapper::toDto).toList();
        //return reviewRepository.findAll();
    }
}

