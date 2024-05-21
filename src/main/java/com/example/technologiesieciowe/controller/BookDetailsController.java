package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.BookDetailsDto;
import com.example.technologiesieciowe.dto.mappers.BookDetailsMapper;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.BookDetails;
import com.example.technologiesieciowe.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

/**
 * The type Book details controller.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/bookDetails")
public class BookDetailsController {

    private final BookDetailsRepository bookDetailsRepository;

    /**
     * Instantiates a new Book details controller.
     *
     * @param bookDetailsRepository the book details repository
     */
    @Autowired
    public BookDetailsController(BookDetailsRepository bookDetailsRepository){
        this.bookDetailsRepository = bookDetailsRepository;
    }

    /**
     * Add book details book details dto.
     *
     * @param bookDetails the book details
     * @return the book details dto
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDetailsDto addBookDetails(@RequestBody BookDetailsDto bookDetails){
        try {
            BookDetails entity = bookDetailsRepository.save(BookDetailsMapper.fromDto(bookDetails));
            return BookDetailsMapper.toDto(entity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot add book details");
        }
//        return bookDetailsRepository.save(BookDetailsMapper.fromDto(bookDetails));
    }

    /**
     * Get all book details iterable.
     *
     * @return the iterable
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDetailsDto> getAllBookDetails(){
        return StreamSupport.stream(bookDetailsRepository.findAll().spliterator(),false).map(BookDetailsMapper::toDto).toList();
        // return bookDetailsRepository.findAll();
    }
}
