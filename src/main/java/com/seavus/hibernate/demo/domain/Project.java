package com.seavus.hibernate.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "projects_skills",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @JsonIgnore
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Cv cv;

    public Project(String name) {
        this.name = name;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.getProjects().add(this);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.getProjects().remove(this);
    }
}
