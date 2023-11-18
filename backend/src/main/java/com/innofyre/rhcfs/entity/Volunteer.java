package com.innofyre.rhcfs.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "firstName cannot be blank")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @JsonManagedReference
    @OneToOne(mappedBy = "volunteer", cascade = CascadeType.ALL, orphanRemoval = true)
    private VolunteerProfile profile;

}
