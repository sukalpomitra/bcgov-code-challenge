package com.innofyre.rhcfs.controller;


import com.innofyre.rhcfs.model.OrderDiscount;
import com.innofyre.rhcfs.model.Volunteer;
import com.innofyre.rhcfs.model.VolunteerRequest;
import com.innofyre.rhcfs.service.OrderDiscountService;
import com.innofyre.rhcfs.service.VolunteerService;
import liquibase.exception.LiquibaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VolunteerController {
    private final VolunteerService volunteerService;

    @PostMapping("/volunteers")
    public ResponseEntity<Volunteer> createVolunteer(@RequestBody VolunteerRequest volunteerRequest) throws LiquibaseException {
        Volunteer volunteer = volunteerService.createVolunteer(volunteerRequest);
        return new ResponseEntity<>(volunteer, HttpStatus.OK);
    }
}
