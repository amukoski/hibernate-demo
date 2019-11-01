package com.seavus.hibernate.demo.repository;

import com.seavus.hibernate.demo.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
