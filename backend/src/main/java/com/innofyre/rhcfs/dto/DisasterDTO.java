package com.innofyre.rhcfs.dto;

import com.innofyre.rhcfs.model.DisasterStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class DisasterDTO {
    private Long id;
    private String name;
    private int criticalLevel;
    private String  location;
    private LocalTime disasterTime;
    private LocalDate disasterDate;
    private DisasterStatus disasterStatus;
}
