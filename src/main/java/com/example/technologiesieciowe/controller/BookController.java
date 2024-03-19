package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.BookDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookRepository bookRepository;
    @Autowired

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDto addBook(@RequestBody BookDto book){
        Book entity = bookRepository.save(BookMapper.fromDto(book));
        return BookMapper.toDto(entity);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDto> getAllBooks(){
        return StreamSupport.stream(bookRepository.findAll().spliterator(),false).map(BookMapper::toDto).toList();
    }
}
