package com.kgisl.sb3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.sb3.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
