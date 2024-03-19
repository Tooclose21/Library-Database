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

import java.util.stream.StreamSupport;

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
    public @ResponseBody BookDetailsDto addBookDetails(@RequestBody BookDetailsDto bookDetails){
        BookDetails entity = bookDetailsRepository.save(BookDetailsMapper.fromDto(bookDetails));
        return BookDetailsMapper.toDto(entity);
//        return bookDetailsRepository.save(BookDetailsMapper.fromDto(bookDetails));
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDetailsDto> getAllBookDetails(){
        return StreamSupport.stream(bookDetailsRepository.findAll().spliterator(),false).map(BookDetailsMapper::toDto).toList();
        // return bookDetailsRepository.findAll();
    }
}
