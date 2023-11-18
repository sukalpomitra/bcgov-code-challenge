package com.innofyre.rhcfs.controller;

import com.innofyre.rhcfs.entity.VolunteerRole;
import com.innofyre.rhcfs.service.VolunteerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${api.prefix}/${api.version}/volunteer-roles", produces = "application/json")
@CrossOrigin
public class VolunteerRoleController {

    private final VolunteerRoleService volunteerService;

    @Autowired
    public VolunteerRoleController(VolunteerRoleService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public List<VolunteerRole> getAllVolunteerRoles() {
        return volunteerService.getAllVolunteerRoles();
    }
}
