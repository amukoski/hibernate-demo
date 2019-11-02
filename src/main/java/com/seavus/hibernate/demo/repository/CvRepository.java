package com.seavus.hibernate.demo.repository;

import com.seavus.hibernate.demo.domain.Cv;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface CvRepository extends CrudRepository<Cv, Long> {

    @EntityGraph("Cv.CvWithEducations")
    Iterable<Cv> findAllByIdNotNull();
}
