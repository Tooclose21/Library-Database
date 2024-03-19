package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.LoanDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.dto.mappers.LoanMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.Loan;
import com.example.technologiesieciowe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/loan")
public class LoanController {

    private final LoanRepository loanRepository;
    @Autowired

    public LoanController(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody LoanDto addLoan(@RequestBody LoanDto loan){
       // return loanRepository.save(loan);

        Loan entity = loanRepository.save(LoanMapper.fromDto(loan));
        return LoanMapper.toDto(entity);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<LoanDto> getAllLoans(){
        return StreamSupport.stream(loanRepository.findAll().spliterator(),false).map(LoanMapper::toDto).toList();
        // return loanRepository.findAll();
    }
}
