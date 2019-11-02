package com.seavus.hibernate.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Cv cv;

    public Language(String name) {
        this.name = name;
    }
}
