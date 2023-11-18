package com.innofyre.rhcfs.dto;
import com.innofyre.rhcfs.model.VolunteerAvailabilityType;
import com.innofyre.rhcfs.model.Weekday;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class VolunteerProfileDTO {
    private Long id;
    private int yearsOfActivity;
    private String emergencyContactNumber;
    private boolean hasOwnTransportation;
    private VolunteerAvailabilityType availabilityType;
    private Set<Weekday> availableDays;
    private List<SkillDTO> skills;
    private VolunteerRequest.LimitationRequest limitation;
}
