package com.innofyre.rhcfs.service;

import com.innofyre.rhcfs.dto.DisasterStatusUpdateRequest;
import com.innofyre.rhcfs.dto.VolunteerDTO;
import com.innofyre.rhcfs.entity.Disaster;
import com.innofyre.rhcfs.exceptions.ResourceNotFoundException;
import com.innofyre.rhcfs.model.DisasterStatus;
import com.innofyre.rhcfs.repository.DisasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DisasterService {

    @Autowired
    private KieContainer kieContainer;

    private DisasterRepository disasterRepository;

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    public DisasterService(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }

    public List<Disaster> getListOfDisasters(String disasterStatus) {
        if (disasterStatus != null) {
          return this.disasterRepository.findByDisasterStatus(DisasterStatus.valueOf(disasterStatus));
        }
        return this.disasterRepository.findAll();
    }

    public Disaster updateDisaster(Long id, Disaster updatedDisaster) {
        if (disasterRepository.existsById(id)) {
            return disasterRepository.save(updatedDisaster);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void updateDisasterStatus(Long id, DisasterStatusUpdateRequest statusUpdateRequest) {
        Disaster existingDisaster = disasterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disaster not found with id: " + id));

        // Update the status if it is not null
        if (statusUpdateRequest.getStatus() != null) {
            existingDisaster.setDisasterStatus(statusUpdateRequest.getStatus());
        }
        disasterRepository.save(existingDisaster);
    }

    public List<VolunteerDTO> getVolunteersByDisasterId(Long id){
        Disaster disaster = this.disasterRepository.findById(id).orElse(null);
        List<VolunteerDTO> volunteers = this.volunteerService.getAllVolunteersWithProfiles();
        KieSession kieSession = kieContainer.newKieSession();
        for (VolunteerDTO volunteerDTO : volunteers ) {
            kieSession.insert(volunteerDTO);
        }
        kieSession.insert(disaster);
        kieSession.fireAllRules();
        kieSession.dispose();

        // Filter volunteers based on their scores or any other criteria
        return volunteers.stream()
                .filter(volunteer -> volunteer.getScore() > 0) // Adjust the condition based on your rules
                .collect(Collectors.toList());
    }
}
