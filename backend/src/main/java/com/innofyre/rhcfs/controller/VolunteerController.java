package com.innofyre.rhcfs.controller;


import com.innofyre.rhcfs.dto.VolunteerDTO;
import com.innofyre.rhcfs.dto.VolunteerRequest;
import com.innofyre.rhcfs.entity.Volunteer;
import com.innofyre.rhcfs.exceptions.ValidationException;
import com.innofyre.rhcfs.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "${api.prefix}/${api.version}/volunteers", produces = "application/json")
@CrossOrigin
@Validated
public class VolunteerController {

    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public ResponseEntity<List<VolunteerDTO>> getAllVolunteers() {
        List<VolunteerDTO> volunteers = volunteerService.getAllVolunteersWithProfiles();
        return new ResponseEntity<>(volunteers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Volunteer getVolunteerById(@PathVariable Long id) {
        return volunteerService.getVolunteerById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<Object> createVolunteer(@Valid @RequestBody VolunteerRequest volunteerRequest) {
      try {
        Volunteer savedVolunteer = volunteerService.saveVolunteerWithProfile(volunteerRequest);
        return ResponseEntity.ok().body(savedVolunteer);
      } catch (ValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
      }
    }

    @PutMapping("/{id}")
    public Volunteer updateVolunteer(@PathVariable Long id, @RequestBody Volunteer updatedVolunteer) {
        return volunteerService.updateVolunteer(id, updatedVolunteer);
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteer(@PathVariable Long id) {
        volunteerService.deleteVolunteer(id);
    }
}
