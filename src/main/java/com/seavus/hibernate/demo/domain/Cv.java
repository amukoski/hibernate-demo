package com.seavus.hibernate.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Language> languages = new ArrayList<>();

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Education> educations = new ArrayList<>();

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Project> projects = new ArrayList<>();

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public void addEducation(Education education) {
        educations.add(education);
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
