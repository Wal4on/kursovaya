package com.university.kursovaya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.kursovaya.models.Loan;
import com.university.kursovaya.services.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> findAll() {
        return loanService.findAll();
    }

    @PostMapping
    public Loan save(@RequestBody Loan loan) {
        return loanService.save(loan);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        loanService.deleteById(id);
    }
}
