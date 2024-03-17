package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.entity.Review;
import com.example.technologiesieciowe.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Review addReview(@RequestBody Review review){

        return reviewRepository.save(review);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
}

