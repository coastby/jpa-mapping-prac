package com.example.springjpamapping.service;

import com.example.springjpamapping.domain.Author;
import com.example.springjpamapping.domain.Book;
import com.example.springjpamapping.dto.BookResponse;
import com.example.springjpamapping.repository.AuthorRepository;
import com.example.springjpamapping.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> findBookds (Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookReponses = books.stream()
                .map(book -> {
                    Optional<Author> authorOpt = authorRepository.findById(book.getAuthorId());
                    return BookResponse.of(book, authorOpt.get());
                }).collect(Collectors.toList());
        return bookReponses;

    }
}
