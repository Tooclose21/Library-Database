package com.example.technologiesieciowe.dto.entity;

/**
 * The type Book dto.
 */
public class BookDto {
    private Integer Id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer yearOfPublish;
    private Integer availableCopies;

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
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     *
     * @param publisher the publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets year of publish.
     *
     * @return the year of publish
     */
    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    /**
     * Sets year of publish.
     *
     * @param yearOfPublish the year of publish
     */
    public void setYearOfPublish(Integer yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    /**
     * Gets available copies.
     *
     * @return the available copies
     */
    public Integer getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Sets available copies.
     *
     * @param availableCopies the available copies
     */
    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
