package com.innofyre.rhcfs.services;

import com.innofyre.rhcfs.dto.VolunteerRequest;
import com.innofyre.rhcfs.entity.Volunteer;
import com.innofyre.rhcfs.repository.VolunteerRepository;
import com.innofyre.rhcfs.service.VolunteerService;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VolunteerServiceTest {

    @Mock
    private VolunteerRepository volunteerRepository;

    @Mock
    private SpringLiquibase liquibase;

    @InjectMocks
    private VolunteerService volunteerService;

    private Volunteer volunteer;

    @BeforeEach
    void setUp() {
        volunteer = new Volunteer();
        volunteer.setId(1L);
        volunteer.setFirstName("Randika");
        volunteer.setLastName("Prasad");
        // Set any other properties as needed
    }

    @Test
    void getAllVolunteers() {
//        List<Volunteer> volunteers = Arrays.asList(volunteer);
//        when(volunteerRepository.findAll()).thenReturn(volunteers);
//
//        List<Volunteer> result = volunteerService.getAllVolunteersWithProfiles();
//
//        assertEquals(volunteers, result);
    }

    @Test
    void getVolunteerById() {
        when(volunteerRepository.findById(1L)).thenReturn(Optional.of(volunteer));

        Optional<Volunteer> result = volunteerService.getVolunteerById(1L);

        assertEquals(Optional.of(volunteer), result);
    }

    @Test
    void createVolunteer() {
//        when(volunteerRepository.save(any(Volunteer.class))).thenReturn(volunteer);
//
//        Volunteer result = volunteerService.createVolunteer(volunteer);
//
//        assertEquals(volunteer, result);
    }

    @Test
    void updateVolunteer() {
        when(volunteerRepository.existsById(1L)).thenReturn(true);
        when(volunteerRepository.save(any(Volunteer.class))).thenReturn(volunteer);

        Volunteer result = volunteerService.updateVolunteer(1L, volunteer);

        assertEquals(volunteer, result);
    }

    @Test
    void deleteVolunteer() {
        volunteerService.deleteVolunteer(1L);
        verify(volunteerRepository, times(1)).deleteById(1L);
    }
}
