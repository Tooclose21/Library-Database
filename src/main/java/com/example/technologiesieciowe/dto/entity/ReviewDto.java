package com.example.technologiesieciowe.dto.entity;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

/**
 * The type Review dto.
 */
public class ReviewDto {
    private Integer Id;

    private BookDto book;

    private UserDto user;
    private Integer rating;
    private String comment;
    private Date reviewDate;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        Id = id;
    }

    /**
     * Gets book.
     *
     * @return the book
     */
    public BookDto getBook() {
        return book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(BookDto book) {
        this.book = book;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public UserDto getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserDto user) {
        this.user = user;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets review date.
     *
     * @return the review date
     */
    public Date getReviewDate() {
        return reviewDate;
    }

    /**
     * Sets review date.
     *
     * @param reviewDate the review date
     */
    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
