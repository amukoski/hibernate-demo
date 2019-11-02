package com.seavus.hibernate.demo.repository;

import com.seavus.hibernate.demo.domain.Cv;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CvRepository extends CrudRepository<Cv, Long> {

    @Override
    @Query("SELECT DISTINCT cv FROM Cv cv " +
            "LEFT JOIN FETCH cv.languages " +
            "LEFT JOIN FETCH cv.educations " +
            "LEFT JOIN FETCH cv.projects")
    Iterable<Cv> findAll();
}
