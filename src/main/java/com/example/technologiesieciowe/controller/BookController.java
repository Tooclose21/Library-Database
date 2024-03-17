package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Book addBook(@RequestBody Book book){

        return bookRepository.save(book);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
