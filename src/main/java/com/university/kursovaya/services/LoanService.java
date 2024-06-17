package com.university.kursovaya.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.kursovaya.models.Loan;
import com.university.kursovaya.repositories.LoanRepository;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}