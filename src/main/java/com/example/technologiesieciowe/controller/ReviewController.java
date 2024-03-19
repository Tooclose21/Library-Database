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

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    @Autowired

    public ReviewController(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody ReviewDto addReview(@RequestBody ReviewDto review){
        Review entity = reviewRepository.save(ReviewMapper.fromDto(review));
        return ReviewMapper.toDto(entity);
        //return reviewRepository.save(review);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<ReviewDto> getAllReviews(){
        return StreamSupport.stream(reviewRepository.findAll().spliterator(),false).map(ReviewMapper::toDto).toList();
        //return reviewRepository.findAll();
    }
}

