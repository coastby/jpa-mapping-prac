package com.example.springjpamapping.dto;

import com.example.springjpamapping.domain.Comment;
import com.example.springjpamapping.domain.Hospital;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class HospitalResponse {
    private Long id;
    private String hospitalName;
    private String roadNameAddress;
    private List<Comment> commentList;

    public static HospitalResponse of(Hospital hospital){
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .commentList(hospital.getCommentList())
                .build();
    }

}
