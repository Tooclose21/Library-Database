package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.entity.Loan;
import com.example.technologiesieciowe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Loan addLoan(@RequestBody Loan loan){

        return loanRepository.save(loan);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Loan> getAllLoans(){
        return loanRepository.findAll();
    }
}
