package com.seavus.hibernate.demo.controller;

import com.seavus.hibernate.demo.domain.Project;
import com.seavus.hibernate.demo.domain.Skill;
import com.seavus.hibernate.demo.repository.ProjectRepository;
import com.seavus.hibernate.demo.repository.SkillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.Arrays.asList;

@SpringBootTest
public class _05_SetsOverLists_ManyToMany_Set {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Test
    void removeChildFromSet() {
        Skill java = createSkill("java");
        Skill ruby = createSkill("ruby");
        Skill html = createSkill("html");
        Skill javascript = createSkill("javascript");
        Project project = createProject(java, ruby, html, javascript);

        System.err.println("****** REMOVE CHILD FROM @ManyToMany SET ******");

        project.removeSkill(java);
        projectRepository.save(project);
    }

    private Project createProject(Skill... skills) {
        Project project = new Project("project");
        asList(skills).forEach(project::addSkill);

        return projectRepository.save(project);
    }

    private Skill createSkill(String name) {
        return skillRepository.save(new Skill(name));
    }
}
