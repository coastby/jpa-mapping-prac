package com.example.springjpamapping.service;

import com.example.springjpamapping.domain.Hospital;
import com.example.springjpamapping.dto.HospitalResponse;
import com.example.springjpamapping.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public HospitalResponse getHospital(Long id){
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(id);
        return HospitalResponse.of(hospitalOptional.get());
    }

    public List<HospitalResponse> getHospitals(Pageable pageable) {
        Page<Hospital> hospitalPage = hospitalRepository.findAll(pageable);
        List<HospitalResponse> hospitalResponses = hospitalPage.stream()
                .map(hospital -> HospitalResponse.of(hospital))
                .collect(Collectors.toList());
        return hospitalResponses;
    }
}
