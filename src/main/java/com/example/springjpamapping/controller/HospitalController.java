package com.example.springjpamapping.controller;

import com.example.springjpamapping.domain.Comment;
import com.example.springjpamapping.domain.Hospital;
import com.example.springjpamapping.dto.CommentRequest;
import com.example.springjpamapping.dto.CommentResponse;
import com.example.springjpamapping.dto.HospitalResponse;
import com.example.springjpamapping.service.CommentService;
import com.example.springjpamapping.service.HospitalService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;
    private final CommentService commentService;

    public HospitalController(HospitalService hospitalService, CommentService commentService) {
        this.hospitalService = hospitalService;
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<HospitalResponse>> showHospitalList(Pageable pageable){
        List<HospitalResponse> hospitalResponses = hospitalService.getHospitals(pageable);
        return ResponseEntity.ok().body(hospitalResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> showHospital(@PathVariable Long id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
//        List<Comment> comments = commentService.getCommentsByHospital(id);
        Map<String, Object>  result = new HashMap<>();
//        result.put("Comments", comments);
        result.put("Data", hospitalResponse);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<CommentResponse>> showHospitalComments(@PathVariable Long id){
        List<CommentResponse> comments = commentService.getCommentsByHospital(id);
        return ResponseEntity.ok().body(comments);
    }
    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<CommentResponse> showAComment(@PathVariable Long id){
        CommentResponse commentResponse = commentService.getComment(id);
        return ResponseEntity.ok().body(commentResponse);
    }
    @PostMapping(value = "/{id}/comments")
    public ResponseEntity<CommentResponse> addComment(@RequestBody CommentRequest commentRequest, @PathVariable Long id){
        CommentResponse commentResponse = commentService.addComment(commentRequest, id);
        return ResponseEntity.ok().body(commentResponse);
    }
}
