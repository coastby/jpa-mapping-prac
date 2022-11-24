package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentRequest {
    private String title;
    private String content;
    private String user;

}
