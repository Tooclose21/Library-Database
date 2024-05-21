package com.example.technologiesieciowe.dto.mappers;

import com.example.technologiesieciowe.dto.entity.LoanDto;
import com.example.technologiesieciowe.entity.Loan;

/**
 * The type Loan mapper.
 */
public class LoanMapper {
    /**
     * To dto loan dto.
     *
     * @param loan the loan
     * @return the loan dto
     */
    public static LoanDto toDto(Loan loan){
    LoanDto loanDto = new LoanDto();
    loanDto.setBook(BookMapper.toDto(loan.getBook()));
    loanDto.setLoanDate(loan.getLoanDate());
    loanDto.setId(loan.getId());
    loanDto.setUser(UserMapper.toDto(loan.getUser()));
    loanDto.setReturnDeadline(loan.getReturnDeadline());
    loanDto.setDateOfReturn(loan.getDateOfReturn());
    return loanDto;
    }

    /**
     * From dto loan.
     *
     * @param loan the loan
     * @return the loan
     */
    public static Loan fromDto(LoanDto loan){
    Loan loanEntity = new Loan();
        loanEntity.setBook(BookMapper.fromDto(loan.getBook()));
        loanEntity.setLoanDate(loan.getLoanDate());
        loanEntity.setId(loan.getId());
        loanEntity.setUser(UserMapper.fromDto(loan.getUser()));
        loanEntity.setReturnDeadline(loan.getReturnDeadline());
        loanEntity.setDateOfReturn(loan.getDateOfReturn());
        return loanEntity;
    }

}
