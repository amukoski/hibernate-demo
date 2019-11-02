package com.seavus.hibernate.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Cv cv;

    public Education(String name) {
        this.name = name;
    }
}
