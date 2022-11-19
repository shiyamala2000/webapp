package com.kgisl.sb3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb3.entity.Book;
import com.kgisl.sb3.repository.BookRepository;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/")
    public List<Book> getAllBooks() {
        bookRepository.findAll().forEach(System.out::println);
        return bookRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) {
        return bookRepository.findById(id);
    }

    @PostMapping(value = "/")
    public void createTeam(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PutMapping(value = "/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable int id) {
        // Book b = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found"));
        // b.setTitle(b.getTitle());
        // b.setAuthor(b.getAuthor());
        // b.setPrice(b.getPrice());

        bookRepository.save(book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
    }
}

