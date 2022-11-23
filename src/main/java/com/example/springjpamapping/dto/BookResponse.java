package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Author;
import com.example.springjpamapping.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookResponse {
    private Long id;
    private String name;
    private String author;

    public static BookResponse of(Book book, Author author){
        return new BookResponse(book.getId(), book.getName(), author.getName());
    }
}
