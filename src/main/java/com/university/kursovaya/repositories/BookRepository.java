package com.university.kursovaya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.kursovaya.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
