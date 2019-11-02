package com.seavus.hibernate.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cv")
    public Set<Language> languages = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cv")
    public Set<Education> educations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cv")
    public Set<Project> projects = new HashSet<>();

    public void addLanguage(Language language) {
        languages.add(language);
        language.setCv(this);
    }

    public void addEducation(Education education) {
        educations.add(education);
        education.setCv(this);
    }

    public void addProject(Project project) {
        projects.add(project);
        project.setCv(this);
    }
}
