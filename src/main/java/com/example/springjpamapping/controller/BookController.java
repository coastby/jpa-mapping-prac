package com.example.springjpamapping.controller;

import com.example.springjpamapping.dto.BookResponse;
import com.example.springjpamapping.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooksWithAuthor(Pageable pageable){
        return ResponseEntity.ok().body(bookService.findBookds(pageable));

    }
}
