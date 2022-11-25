package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Comment;
import com.example.springjpamapping.domain.Hospital;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class HospitalResponse {
    private Long id;
    private String hospitalName;
    private String roadNameAddress;
    private Long totalCommentNum;
    private List<CommentResponse> commentList;

    public static HospitalResponse of(Hospital hospital){
        List<CommentResponse> commentResponses = hospital.getCommentList()
                .stream().map(CommentResponse::of).collect(Collectors.toList());
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .totalCommentNum((long) commentResponses.size())        //총 댓글 개수 추가
                .commentList(commentResponses)
                .build();
    }

}
