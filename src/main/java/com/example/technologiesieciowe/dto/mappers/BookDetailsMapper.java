package com.example.technologiesieciowe.dto.mappers;

import com.example.technologiesieciowe.dto.entity.BookDetailsDto;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.BookDetails;

/**
 * The type Book details mapper.
 */
public class BookDetailsMapper {
    /**
     * To dto book details dto.
     *
     * @param bookDetails the book details
     * @return the book details dto
     */
    public static BookDetailsDto toDto(BookDetails bookDetails){
        BookDetailsDto bookDetailsDto = new BookDetailsDto();
        bookDetailsDto.setSummary(bookDetails.getSummary());
        bookDetailsDto.setGenre(bookDetails.getGenre());
        bookDetailsDto.setCoverImageURL(bookDetails.getCoverImageURL());
        bookDetailsDto.setBook(BookMapper.toDto(bookDetails.getBook()));
        bookDetailsDto.setId(bookDetails.getId());
        return bookDetailsDto;
    }

    /**
     * From dto book details.
     *
     * @param bookDetails the book details
     * @return the book details
     */
    public static BookDetails fromDto(BookDetailsDto bookDetails){
        BookDetails bookDetailsEntity = new BookDetails();
        bookDetailsEntity.setSummary(bookDetails.getSummary());
        bookDetailsEntity.setGenre(bookDetails.getGenre());
        bookDetailsEntity.setCoverImageURL(bookDetails.getCoverImageURL());
        bookDetailsEntity.setBook(BookMapper.fromDto(bookDetails.getBook()));
        bookDetailsEntity.setId(bookDetails.getId());
        return bookDetailsEntity;
    }
}
