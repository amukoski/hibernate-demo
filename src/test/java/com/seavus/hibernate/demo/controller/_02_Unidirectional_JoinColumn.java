package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.Cv;
import com.seavus.hibernate.demo.domain.Language;
import com.seavus.hibernate.demo.repository.CvRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class _02_Unidirectional_JoinColumn {

    @Autowired
    private CvRepository cvRepository;

    @Test
    void unidirectional_JoinColumn() {
        Cv cv = new Cv();
        cv.addLanguage(new Language("English"));
        cv.addLanguage(new Language("Serbian"));
        cv.addLanguage(new Language("Macedonian"));

        System.err.println("****** UNIDIRECTIONAL JoinColumn ******");

        cvRepository.save(cv);
    }
}
