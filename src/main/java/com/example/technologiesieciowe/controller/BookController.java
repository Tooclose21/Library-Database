package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.BookDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import com.example.technologiesieciowe.filters.LoginForm;
import com.example.technologiesieciowe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

/**
 * The type Book controller.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/book")
public class BookController {

    private final BookRepository bookRepository;

    /**
     * Instantiates a new Book controller.
     *
     * @param bookRepository the book repository
     */
    @Autowired

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    /**
     * Add book book dto.
     *
     * @param book the book
     * @return the book dto
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDto addBook(@RequestBody BookDto book){
        try {
            Book entity = bookRepository.save(BookMapper.fromDto(book));
            return BookMapper.toDto(entity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot add book");
        }
    }

    /**
     * Get all books iterable.
     *
     * @return the iterable
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDto> getAllBooks(){
        return StreamSupport.stream(bookRepository.findAll().spliterator(),false).map(BookMapper::toDto).toList();
    }

    /**
     * Get book by title book dto.
     *
     * @param title the title
     * @return the book dto
     */
    @GetMapping("/getByTitle")
    public @ResponseBody BookDto getBookByTitle(@RequestParam String title){
        return BookMapper.toDto(bookRepository.findByTitle(title));
    }

    /**
     * Delete book.
     *
     * @param isbn the isbn
     */
    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam String isbn){
        try {
            bookRepository.delete(bookRepository.findByIsbn(isbn));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot delete book");
        }
    }
}
