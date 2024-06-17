package com.university.kursovaya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.kursovaya.models.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
