package com.example.technologiesieciowe.dto.entity;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

public class LoanDto {
    private Integer Id;

    private BookDto book;

    private UserDto user;
    private Date loanDate;
    private Date returnDeadline;
    private Date dateOfReturn;

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

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDeadline() {
        return returnDeadline;
    }

    public void setReturnDeadline(Date returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
