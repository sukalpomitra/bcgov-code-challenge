package com.innofyre.rhcfs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "volunteer-role")
public class VolunteerRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "description")
    private String description;

    @Column(name = "code", nullable = false)
    private int code;
}
