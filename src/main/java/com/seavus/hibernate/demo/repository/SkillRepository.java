package com.seavus.hibernate.demo.repository;

import com.seavus.hibernate.demo.domain.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Long> {
}
