package com.innofyre.rhcfs.repository;

import com.innofyre.rhcfs.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    @Query("SELECT v FROM Volunteer v LEFT JOIN FETCH v.profile vp LEFT JOIN FETCH vp.volunteerSkills")
    List<Volunteer> findAllWithProfiles();
}
