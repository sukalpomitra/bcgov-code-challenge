package com.innofyre.rhcfs.service;

import com.innofyre.rhcfs.dto.SkillDTO;
import com.innofyre.rhcfs.dto.VolunteerDTO;
import com.innofyre.rhcfs.dto.VolunteerProfileDTO;
import com.innofyre.rhcfs.dto.VolunteerRequest;
import com.innofyre.rhcfs.entity.Skill;
import com.innofyre.rhcfs.entity.Volunteer;
import com.innofyre.rhcfs.entity.VolunteerProfile;
import com.innofyre.rhcfs.entity.VolunteerSkill;
import com.innofyre.rhcfs.model.SkillLevel;
import com.innofyre.rhcfs.model.VolunteerAvailabilityType;
import com.innofyre.rhcfs.model.Weekday;
import com.innofyre.rhcfs.repository.SkillRepository;
import com.innofyre.rhcfs.repository.VolunteerProfileRepository;
import com.innofyre.rhcfs.repository.VolunteerRepository;
import liquibase.integration.spring.SpringLiquibase;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VolunteerService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private SpringLiquibase liquibase;

    @Autowired
    private SkillRepository skillRepository;

    private VolunteerRepository volunteerRepository;

    private final VolunteerProfileRepository volunteerProfileRepository;

    @Autowired
    public VolunteerService(VolunteerRepository volunteerRepository,
                            VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerRepository = volunteerRepository;
        this.volunteerProfileRepository = volunteerProfileRepository;
    }

    public List<VolunteerDTO> getAllVolunteersWithProfiles() {
        List<Volunteer> volunteers = volunteerRepository.findAllWithProfiles();
        return volunteers.stream()
                .map(this::mapToVolunteerDTO)
                .collect(Collectors.toList());
    }

    private VolunteerDTO mapToVolunteerDTO(Volunteer volunteer) {
        VolunteerDTO volunteerDTO = new VolunteerDTO();
        volunteerDTO.setId(volunteer.getId());
        volunteerDTO.setFirstName(volunteer.getFirstName());
        volunteerDTO.setLastName(volunteer.getLastName());
        volunteerDTO.setPhoneNumber(volunteer.getPhoneNumber());
        volunteerDTO.setEmail(volunteer.getEmail());
        volunteerDTO.setGender(volunteer.getGender());

        VolunteerProfileDTO profileDTO = new VolunteerProfileDTO();
        profileDTO.setId(volunteer.getProfile().getId());
        profileDTO.setYearsOfActivity(volunteer.getProfile().getYearsOfActivity());
        profileDTO.setEmergencyContactNumber(volunteer.getProfile().getEmergencyContactNumber());
        profileDTO.setHasOwnTransportation(volunteer.getProfile().isHasOwnTransportation());
        profileDTO.setAvailabilityType(volunteer.getProfile().getAvailabilityType());
        profileDTO.setAvailableDays(volunteer.getProfile().getAvailableDays());
        profileDTO.setLimitation(volunteer.getProfile().getLimitation());

        List<SkillDTO> skillDTOs = volunteer.getProfile().getVolunteerSkills().stream()
                .map(this::mapToSkillDTO)
                .collect(Collectors.toList());

        profileDTO.setSkills(skillDTOs);
        volunteerDTO.setProfile(profileDTO);

        return volunteerDTO;
    }

    private SkillDTO mapToSkillDTO(VolunteerSkill volunteerSkill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(volunteerSkill.getId());
        skillDTO.setSkillCode(volunteerSkill.getSkill().getCode()); // Assuming you have a field for skill name in VolunteerSkill entity
        skillDTO.setSkillLevel(SkillLevel.fromValue(volunteerSkill.getSkillLevel()));
        return skillDTO;
    }

    public Optional<Volunteer> getVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        VolunteerProfile p = volunteerProfileRepository.save(volunteer.getProfile());
        volunteer.setProfile(p);
        return volunteerRepository.save(volunteer);
    }

    public Volunteer saveVolunteerWithProfile(VolunteerRequest volunteerRequest) {
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(volunteerRequest.getFirstName());
        volunteer.setLastName(volunteerRequest.getLastName());
        volunteer.setPhoneNumber(volunteerRequest.getPhoneNumber());
        volunteer.setEmail(volunteerRequest.getEmail());
        volunteer.setGender(volunteerRequest.getGender());
        volunteer.setDateOfBirth(volunteerRequest.getDateOfBirth());

        VolunteerProfile profile = new VolunteerProfile();
        profile.setHasOwnTransportation(volunteerRequest.getProfile().isHasOwnTransportation());
        profile.setAvailabilityType(volunteerRequest.getProfile().getAvailabilityType());

        if (volunteerRequest.getProfile().getLimitation() != null) {
          profile.setLimitation(volunteerRequest.getProfile().getLimitation());
        } else {
          VolunteerRequest.LimitationRequest request = new VolunteerRequest.LimitationRequest();
          request.setHasLimitation(false);
          request.setLimitationCodes(new ArrayList<>());
          profile.setLimitation(request);
        }
        profile.setEmergencyContactNumber(volunteerRequest.getProfile().getEmergencyContactNumber());

        for (VolunteerRequest.SkillRequest skill : volunteerRequest.getProfile().getSkills()) {
            VolunteerSkill volunteerSkill = new VolunteerSkill();
            volunteerSkill.setVolunteerProfile(profile);
            volunteerSkill.setSkill(findOrCreateSkill(skill.getSkillCode()));
            volunteerSkill.setSkillLevel(skill.getSkillLevel().getValue());
            profile.getVolunteerSkills().add(volunteerSkill);
        }

        if (profile.getAvailabilityType() == VolunteerAvailabilityType.CUSTOM) {
            List<Weekday> weekdaysList = volunteerRequest.getProfile().getAvailableDays();
            Set<Weekday> weekdaysSet = new HashSet<>(weekdaysList);
            profile.setAvailableDays(weekdaysSet);
        } else {
            Set<Weekday> weekdays = new HashSet<>(List.of(Weekday.SUNDAY, Weekday.MONDAY, Weekday.THURSDAY, Weekday.WEDNESDAY, Weekday.FRIDAY, Weekday.SATURDAY));
            profile.setAvailableDays(weekdays);
        }

        volunteer.setProfile(profile);
        profile.setVolunteer(volunteer);

        return volunteerRepository.save(volunteer);
    }

    private Skill findOrCreateSkill(int code) {
        Optional<Skill> existingSkill = this.skillRepository.findByCode(code);
        return existingSkill.orElseGet(() -> {
            Skill newSkill = new Skill();
            newSkill.setCode(code);
            return this.skillRepository.save(newSkill);
        });
    }

    public Volunteer updateVolunteer(Long id, Volunteer updatedVolunteer) {
        if (volunteerRepository.existsById(id)) {
            return volunteerRepository.save(updatedVolunteer);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}
