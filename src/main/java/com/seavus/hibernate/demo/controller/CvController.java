package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.Cv;
import com.seavus.hibernate.demo.repository.CvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cvs")
public class CvController {

    private final CvRepository cvRepository;

    @GetMapping
    public Iterable<Cv> findAllCv() {
        return cvRepository.findAll();
    }

    @PostMapping
    public Cv createCv(@RequestBody Cv cv) {
        return cvRepository.save(cv);
    }
}
