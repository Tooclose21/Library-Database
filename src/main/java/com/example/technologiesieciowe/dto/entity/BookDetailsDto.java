package com.example.technologiesieciowe.dto.entity;

import com.example.technologiesieciowe.entity.Book;
import jakarta.persistence.OneToOne;

/**
 * The type Book details dto.
 */
public class BookDetailsDto {
    private Integer Id;
    private BookDto book;
    private String genre;
    private String summary;
    private String coverImageURL;

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
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets summary.
     *
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets summary.
     *
     * @param summary the summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets cover image url.
     *
     * @return the cover image url
     */
    public String getCoverImageURL() {
        return coverImageURL;
    }

    /**
     * Sets cover image url.
     *
     * @param coverImageURL the cover image url
     */
    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }
}
