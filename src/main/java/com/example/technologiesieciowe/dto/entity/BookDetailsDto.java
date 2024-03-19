package com.example.technologiesieciowe.dto.entity;

import com.example.technologiesieciowe.entity.Book;
import jakarta.persistence.OneToOne;

public class BookDetailsDto {
    private Integer Id;
    private BookDto book;
    private String genre;
    private String summary;
    private String coverImageURL;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }
}
