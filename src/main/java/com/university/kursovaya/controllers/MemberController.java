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

import com.university.kursovaya.models.Member;
import com.university.kursovaya.services.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @PostMapping
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
    }
}
