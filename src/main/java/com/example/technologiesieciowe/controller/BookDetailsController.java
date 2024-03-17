package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.entity.BookDetails;
import com.example.technologiesieciowe.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bookDetails")
public class BookDetailsController {

    private final BookDetailsRepository bookDetailsRepository;
    @Autowired
    public BookDetailsController(BookDetailsRepository bookDetailsRepository){
        this.bookDetailsRepository = bookDetailsRepository;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDetails addBookDetails(@RequestBody BookDetails bookDetails){

        return bookDetailsRepository.save(bookDetails);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDetails> getAllBookDetails(){
        return bookDetailsRepository.findAll();
    }
}
