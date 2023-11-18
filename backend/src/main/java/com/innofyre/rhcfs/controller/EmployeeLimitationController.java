package com.innofyre.rhcfs.controller;
import com.innofyre.rhcfs.service.EmployeeLimitationService;
import com.innofyre.rhcfs.entity.EmployeeLimitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${api.prefix}/${api.version}/employee-limitations", produces = "application/json")
@CrossOrigin
public class EmployeeLimitationController {

    private final EmployeeLimitationService employeeLimitationService;

    @Autowired
    public EmployeeLimitationController(EmployeeLimitationService employeeLimitationService) {
        this.employeeLimitationService = employeeLimitationService;
    }

    @GetMapping
    public List<EmployeeLimitation> getListOfEmployeeLimitation() {
        return this.employeeLimitationService.getListOfEmployeeLimitation();
    }
}
