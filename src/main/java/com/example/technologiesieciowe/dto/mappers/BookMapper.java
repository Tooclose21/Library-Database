package com.example.technologiesieciowe.dto.mappers;

import com.example.technologiesieciowe.dto.entity.BookDto;
import com.example.technologiesieciowe.entity.Book;

public class BookMapper {
    public static BookDto toDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setPublisher(book.getPublisher());
        bookDto.setAvailableCopies(book.getAvailableCopies());
        bookDto.setTitle(book.getTitle());
        bookDto.setYearOfPublish(book.getYearOfPublish());
        bookDto.setId(book.getId());
        return bookDto;
    }

    public static Book fromDto(BookDto book){
        Book bookEntity = new Book();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setAvailableCopies(book.getAvailableCopies());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setYearOfPublish(book.getYearOfPublish());
        bookEntity.setId(book.getId());
        return bookEntity;
    }
}
