package com.innofyre.rhcfs.repository;

import com.innofyre.rhcfs.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByCode(Integer code);
}
