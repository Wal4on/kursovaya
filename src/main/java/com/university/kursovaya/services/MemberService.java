package com.university.kursovaya.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.kursovaya.models.Book;
import com.university.kursovaya.models.Member;
import com.university.kursovaya.repositories.MemberRepository;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}