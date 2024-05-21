package com.example.technologiesieciowe.dto.entity;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

/**
 * The type Loan dto.
 */
public class LoanDto {
    private Integer Id;

    private BookDto book;

    private UserDto user;
    private Date loanDate;
    private Date returnDeadline;
    private Date dateOfReturn;

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
     * Gets loan date.
     *
     * @return the loan date
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * Sets loan date.
     *
     * @param loanDate the loan date
     */
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * Gets return deadline.
     *
     * @return the return deadline
     */
    public Date getReturnDeadline() {
        return returnDeadline;
    }

    /**
     * Sets return deadline.
     *
     * @param returnDeadline the return deadline
     */
    public void setReturnDeadline(Date returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    /**
     * Gets date of return.
     *
     * @return the date of return
     */
    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    /**
     * Sets date of return.
     *
     * @param dateOfReturn the date of return
     */
    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
