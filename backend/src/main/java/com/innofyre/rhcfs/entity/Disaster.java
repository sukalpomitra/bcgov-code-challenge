package com.innofyre.rhcfs.entity;


import com.innofyre.rhcfs.model.DisasterStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "disaster")
public class Disaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "critical_level")
    private int criticalLevel;

    @Column(name = "location")
    private String  location;

    @Column(name = "disaster_time")
    private LocalTime disasterTime;

    @Column(name = "disaster_date")
    private LocalDate  disasterDate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private DisasterStatus disasterStatus;
}
