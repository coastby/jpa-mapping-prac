package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Author;
import com.example.springjpamapping.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BookResponse {
    private Long id;
    private String name;
    private String author;
    private String publisher;

    public static BookResponse of(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor().getName())
                .publisher(book.getPublisher().getName())
                .build();
    }
}
