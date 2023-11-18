package com.innofyre.rhcfs.controller;


import com.innofyre.rhcfs.dto.DisasterStatusUpdateRequest;
import com.innofyre.rhcfs.dto.VolunteerDTO;
import com.innofyre.rhcfs.entity.Disaster;
import com.innofyre.rhcfs.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.prefix}/${api.version}/disasters", produces = "application/json")
@CrossOrigin
public class DisasterController {

    private final DisasterService disasterService;

    @Autowired
    public DisasterController(DisasterService disasterService) {
        this.disasterService = disasterService;
    }

    @GetMapping
    public List<Disaster> getListOfDisasters(@RequestParam(name = "disasterStatus", required = false) String disasterStatus) {
        return this.disasterService.getListOfDisasters(disasterStatus);
    }

    @GetMapping("/{disasterId}/volunteers")
    public ResponseEntity<List<VolunteerDTO>> getVolunteersByDisasterId(@PathVariable Long disasterId) {
        List<VolunteerDTO> volunteers = this.disasterService.getVolunteersByDisasterId(disasterId);
        return new ResponseEntity<>(volunteers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Disaster updateDisaster(@PathVariable Long id, @RequestBody Disaster updatedDisaster) {
        return disasterService.updateDisaster(id, updatedDisaster);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateDisasterStatus(@PathVariable Long id, @RequestBody DisasterStatusUpdateRequest statusUpdateRequest) {
        disasterService.updateDisasterStatus(id, statusUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}
