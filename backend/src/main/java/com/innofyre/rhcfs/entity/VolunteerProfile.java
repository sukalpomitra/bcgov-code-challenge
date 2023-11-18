package com.innofyre.rhcfs.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.innofyre.rhcfs.dto.VolunteerRequest;
import com.innofyre.rhcfs.helpers.LimitationConverter;
import com.innofyre.rhcfs.model.VolunteerAvailabilityType;
import com.innofyre.rhcfs.model.Weekday;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "volunteer-profile")
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "years_of_activity")
    private int yearsOfActivity;

    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;

    @Column(name = "has_own_transportation")
    private boolean hasOwnTransportation;

    @Column(name = "limitation", columnDefinition = "jsonb")
    @Convert(converter = LimitationConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private VolunteerRequest.LimitationRequest limitation;

    @Column(name = "availability_type")
    @Enumerated(EnumType.ORDINAL)
    private VolunteerAvailabilityType availabilityType;

    @ElementCollection(targetClass = Weekday.class)
    @CollectionTable(name = "volunteer-available-days", joinColumns = @JoinColumn(name = "volunteer_profile_id"))
    @Column(name = "days")
    private Set<Weekday> availableDays;


    @OneToMany(mappedBy = "volunteerProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VolunteerSkill> volunteerSkills = new HashSet<>();

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;
}
