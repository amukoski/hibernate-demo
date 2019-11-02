package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.Cv;
import com.seavus.hibernate.demo.repository.CvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cvs")
public class CvController {

    private final CvRepository cvRepository;

    @GetMapping
    public Iterable<Cv> findAllCvs() {
        return cvRepository.findAll();
    }
}
