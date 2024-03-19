package com.example.technologiesieciowe.dto.entity;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

public class ReviewDto {
    private Integer Id;

    private BookDto book;

    private UserDto user;
    private Integer rating;
    private String comment;
    private Date reviewDate;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
