package com.innofyre.rhcfs.service;


import com.innofyre.rhcfs.entity.VolunteerRole;
import com.innofyre.rhcfs.repository.VolunteerRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class VolunteerRoleService {

    private final VolunteerRoleRepository volunteerRoleRepository;

    @Autowired
    public VolunteerRoleService(VolunteerRoleRepository volunteerRoleRepository) {
        this.volunteerRoleRepository = volunteerRoleRepository;
    }

    @GetMapping
    public List<VolunteerRole> getAllVolunteerRoles() {
        return this.volunteerRoleRepository.findAll();
    }
}
