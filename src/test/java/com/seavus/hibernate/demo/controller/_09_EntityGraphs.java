package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.Cv;
import com.seavus.hibernate.demo.domain.Education;
import com.seavus.hibernate.demo.domain.Language;
import com.seavus.hibernate.demo.domain.Project;
import com.seavus.hibernate.demo.repository.CvRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class _09_EntityGraphs {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CvRepository cvRepository;

    @BeforeEach
    void persist_5_Cvs_Into_Database() {
        cvRepository.saveAll(asList(createCv(), createCv(), createCv(), createCv(), createCv()));
    }

    @Test
    void entityGraphFetchFullCv() throws Exception {
        mockMvc.perform(get("/api/cvs"));
    }

    @Test
    void entityGraphFetchFullCvWithProjectsTogether() throws Exception {
        mockMvc.perform(get("/api/cvs/full-cv"));
    }

    private Cv createCv() {
        Cv cv = new Cv();
        cv.addLanguage(new Language("language"));
        cv.addEducation(new Education("education"));
        cv.addProject(new Project("project"));

        return cv;
    }
}
