package com.example.springjpamapping.controller;

import com.example.springjpamapping.domain.Comment;
import com.example.springjpamapping.domain.Hospital;
import com.example.springjpamapping.dto.HospitalResponse;
import com.example.springjpamapping.service.HospitalService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/hospitals")
public class HospitalController {
    HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public ResponseEntity<List<HospitalResponse>> showHospitalList(Pageable pageable){
        List<HospitalResponse> hospitalResponses = hospitalService.getHospitals(pageable);
        return ResponseEntity.ok().body(hospitalResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Comment>> showHospital(@PathVariable Long id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        List<Comment> result = hospitalResponse.getCommentList();
        return ResponseEntity.ok().body(result);
    }
}
