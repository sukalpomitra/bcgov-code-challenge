package com.innofyre.rhcfs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "volunteer-skills")
public class VolunteerSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "volunteer_profile_id")
    private VolunteerProfile volunteerProfile;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_level")
    private int skillLevel;
}
