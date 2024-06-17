package com.university.kursovaya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.kursovaya.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
