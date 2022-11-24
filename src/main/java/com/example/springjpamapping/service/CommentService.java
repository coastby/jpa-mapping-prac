package com.example.springjpamapping.service;

import com.example.springjpamapping.domain.Comment;
import com.example.springjpamapping.domain.Hospital;
import com.example.springjpamapping.dto.CommentRequest;
import com.example.springjpamapping.dto.CommentResponse;
import com.example.springjpamapping.repository.CommentRepository;
import com.example.springjpamapping.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final HospitalRepository hospitalRepository;

    public CommentService(CommentRepository commentRepository, HospitalRepository hospitalRepository) {
        this.commentRepository = commentRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public CommentResponse addComment(CommentRequest commentRequest, Long id) {
        Optional<Hospital> hospitalOpt = hospitalRepository.findById(id);
        Comment comment = Comment.builder()
                .title(commentRequest.getTitle())
                .content(commentRequest.getContent())
                .user(commentRequest.getUser())
                .hospital(hospitalOpt.get())
                .build();
        Comment savedComment = commentRepository.save(comment);
        return CommentResponse.of(savedComment);
    }
    public List<CommentResponse> getCommentsByHospital(Long id){
        List<CommentResponse> comments = commentRepository.findAllByHospitalId(id).stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
        return comments;
    }

    public CommentResponse getComment(Long id) {
        Optional<Comment> commentOpt = commentRepository.findById(id);
        return CommentResponse.of(commentOpt.get());
    }
}
