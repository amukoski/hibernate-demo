package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.*;
import com.seavus.hibernate.demo.repository.CvRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class _10_EntityGraphs_Subselect {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CvRepository cvRepository;

    @BeforeEach
    void persist_20_Cvs_Into_Database() {
        IntStream.range(0, 20).mapToObj(value -> {
            // 10 Languages
            // 5 Educations
            // 15 Project with 20 skills
            Cv cv = new Cv();
            IntStream.range(0, 10).mapToObj(String::valueOf).map(Language::new).forEach(cv::addLanguage);
            IntStream.range(0, 5).mapToObj(String::valueOf).map(Education::new).forEach(cv::addEducation);
            IntStream.range(0, 15).mapToObj(String::valueOf).map(Project::new).forEach(project -> {
                IntStream.range(0, 20).mapToObj(String::valueOf).map(Skill::new).forEach(project::addSkill);
                cv.addProject(project);
            });
            return cv;
        }).forEach(cvRepository::save);
    }

    @Test
    void entityGraphFetchFullCv() throws Exception {
        mockMvc.perform(get("/api/cvs"));
    }

    @Test
    void entityGraphFetchFullCvWithProjectSkillsTogether() throws Exception {
        mockMvc.perform(get("/api/cvs/full-cv"));
    }
}
