package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.Cv;
import com.seavus.hibernate.demo.domain.Language;
import com.seavus.hibernate.demo.repository.CvRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class _03_Bidirectional {

    @Autowired
    private CvRepository cvRepository;

    @Test
    void bidirectional() {
        Cv cv = new Cv();
        Language english = new Language("English");
        Language serbian = new Language("Serbian");
        Language macedonian = new Language("Macedonian");

        english.setCv(cv);
        serbian.setCv(cv);
        macedonian.setCv(cv);

        cv.addLanguage(english);
        cv.addLanguage(serbian);
        cv.addLanguage(macedonian);

        System.err.println("****** BIDIRECTIONAL ******");

        cvRepository.save(cv);
    }
}
