package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {
    private String title;
    private String content;
    private String user;
    private String hospitalName;


    public static CommentResponse of(Comment comment){
        return CommentResponse.builder()
                .title(comment.getTitle())
                .content(comment.getContent())
                .user(comment.getUser())
                .hospitalName(comment.getHospital().getHospitalName())
                .build();
    }

}
