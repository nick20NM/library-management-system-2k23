package com.alpha.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
