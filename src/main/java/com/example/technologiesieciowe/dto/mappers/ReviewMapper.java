package com.example.technologiesieciowe.dto.mappers;

import com.example.technologiesieciowe.dto.entity.LoanDto;
import com.example.technologiesieciowe.dto.entity.ReviewDto;
import com.example.technologiesieciowe.entity.Loan;
import com.example.technologiesieciowe.entity.Review;

/**
 * The type Review mapper.
 */
public class ReviewMapper {
    /**
     * To dto review dto.
     *
     * @param review the review
     * @return the review dto
     */
    public static ReviewDto toDto(Review review){
    ReviewDto reviewDto = new ReviewDto();
    reviewDto.setBook(BookMapper.toDto(review.getBook()));
    reviewDto.setId(review.getId());
    reviewDto.setReviewDate(review.getReviewDate());
    reviewDto.setUser(UserMapper.toDto(review.getUser()));
    reviewDto.setComment(review.getComment());
    reviewDto.setRating(review.getRating());
    return reviewDto;
    }

    /**
     * From dto review.
     *
     * @param review the review
     * @return the review
     */
    public static Review fromDto(ReviewDto review){
    Review reviewEntity = new Review();
        reviewEntity.setBook(BookMapper.fromDto(review.getBook()));
        reviewEntity.setId(review.getId());
        reviewEntity.setReviewDate(review.getReviewDate());
        reviewEntity.setUser(UserMapper.fromDto(review.getUser()));
        reviewEntity.setComment(review.getComment());
        reviewEntity.setRating(review.getRating());
        return reviewEntity;

    }
}
