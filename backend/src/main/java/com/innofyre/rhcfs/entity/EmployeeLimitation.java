package com.innofyre.rhcfs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employee-limitation")
public class EmployeeLimitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "limitation")
    private String limitation;

    @Column(name = "code")
    private int code;
}
