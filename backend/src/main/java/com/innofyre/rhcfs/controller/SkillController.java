package com.innofyre.rhcfs.controller;

import com.innofyre.rhcfs.entity.Skill;
import com.innofyre.rhcfs.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${api.prefix}/${api.version}/skills", produces = "application/json")
@CrossOrigin
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getListOfSkills() {
        return new ResponseEntity<List<Skill>>(this.skillService.getListOfSkills(), HttpStatus.OK);
    }
}
