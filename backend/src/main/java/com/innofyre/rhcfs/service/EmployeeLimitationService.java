package com.innofyre.rhcfs.service;


import com.innofyre.rhcfs.entity.EmployeeLimitation;
import com.innofyre.rhcfs.repository.EmployeeLimitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLimitationService {

    private EmployeeLimitationRepository employeeLimitationRepository;

    @Autowired
    public EmployeeLimitationService(EmployeeLimitationRepository employeeLimitationRepository) {
        this.employeeLimitationRepository = employeeLimitationRepository;
    }

    public List<EmployeeLimitation> getListOfEmployeeLimitation() {
        return this.employeeLimitationRepository.findAll();
    }

}
