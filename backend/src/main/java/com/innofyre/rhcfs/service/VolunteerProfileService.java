package com.innofyre.rhcfs.service;

import com.innofyre.rhcfs.entity.VolunteerProfile;
import com.innofyre.rhcfs.entity.VolunteerSkill;
import com.innofyre.rhcfs.repository.VolunteerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VolunteerProfileService {

    @Autowired
    private VolunteerProfileRepository volunteerProfileRepository;

    @Transactional
    public VolunteerProfile saveVolunteerProfileWithSkills(VolunteerProfile volunteerProfile) {
        // Ensure skills are associated with the profile
        for (VolunteerSkill skill : volunteerProfile.getVolunteerSkills()) {
            skill.setVolunteerProfile(volunteerProfile);
        }
        return volunteerProfileRepository.save(volunteerProfile);
    }
}