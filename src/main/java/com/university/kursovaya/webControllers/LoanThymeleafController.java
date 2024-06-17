package com.university.kursovaya.webControllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.university.kursovaya.models.Loan;
import com.university.kursovaya.services.BookService;
import com.university.kursovaya.services.LoanService;
import com.university.kursovaya.services.MemberService;

@Controller
public class LoanThymeleafController {
    @Autowired
    private LoanService loanService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/loans")
    public String getLoans(Model model) {
        model.addAttribute("loans", loanService.findAll());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("members", memberService.findAll());
        return "loan";
    }

    @PostMapping("/loans/add")
    public String addLoan(@RequestParam Long bookId, @RequestParam Long memberId, @RequestParam String loanDate, @RequestParam String returnDate) {
        Loan loan = new Loan();
        loan.setBook(bookService.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID")));
        loan.setMember(memberService.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Invalid member ID")));
        loan.setLoanDate(Date.valueOf(loanDate));
        loan.setReturnDate(Date.valueOf(returnDate));
        loanService.save(loan);
        return "redirect:/loans";
    }

    @PostMapping("/loans/delete/{id}")
    public String deleteLoan(@PathVariable Long id) {
        loanService.deleteById(id);
        return "redirect:/loans";
    }
}