package com.example.technologiesieciowe.repository;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, Integer> {
    Iterable<Loan> findByUser_Id(int id);
}
