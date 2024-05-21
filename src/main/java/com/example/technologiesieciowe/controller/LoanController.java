package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.BookDto;
import com.example.technologiesieciowe.dto.entity.LoanDto;
import com.example.technologiesieciowe.dto.entity.UserDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.dto.mappers.LoanMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.Loan;
import com.example.technologiesieciowe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

/**
 * The type Loan controller.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/loan")
public class LoanController {

    private final LoanRepository loanRepository;

    /**
     * Instantiates a new Loan controller.
     *
     * @param loanRepository the loan repository
     */
    @Autowired

    public LoanController(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    /**
     * Add loan loan dto.
     *
     * @param loan the loan
     * @return the loan dto
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody LoanDto addLoan(@RequestBody LoanDto loan){
       // return loanRepository.save(loan);

        try {
            Loan entity = loanRepository.save(LoanMapper.fromDto(loan));
            return LoanMapper.toDto(entity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot add loan");
        }
    }

    /**
     * Get all loans iterable.
     *
     * @return the iterable
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<LoanDto> getAllLoans(){
        return StreamSupport.stream(loanRepository.findAll().spliterator(),false).map(LoanMapper::toDto).toList();
        // return loanRepository.findAll();
    }

    /**
     * Get by user id iterable.
     *
     * @param userID the user id
     * @return the iterable
     */
    @GetMapping("/getByUserID")
    public @ResponseBody Iterable<LoanDto> getByUserID(@RequestParam int userID){
        return StreamSupport.stream(loanRepository.findByUser_Id(userID).spliterator(),false).map(LoanMapper::toDto).toList();
    }
}
