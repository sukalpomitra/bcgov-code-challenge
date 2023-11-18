package com.innofyre.rhcfs.service;

import com.innofyre.rhcfs.entity.Skill;
import com.innofyre.rhcfs.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getListOfSkills() {
        return this.skillRepository.findAll();
    }
}
