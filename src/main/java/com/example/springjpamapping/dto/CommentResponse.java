package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponse {
    private String title;
    private String content;
    private String user;

    @Builder
    public CommentResponse(String title, String content, String user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public static CommentResponse of(Comment comment){
        return CommentResponse.builder()
                .title(comment.getTitle())
                .content(comment.getContent())
                .user(comment.getUser())
                .build();
    }

}
