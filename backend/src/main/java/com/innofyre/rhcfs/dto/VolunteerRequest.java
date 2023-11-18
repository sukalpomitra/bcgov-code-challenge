package com.innofyre.rhcfs.dto;

import com.innofyre.rhcfs.model.SkillLevel;
import com.innofyre.rhcfs.model.VolunteerAvailabilityType;
import com.innofyre.rhcfs.model.Weekday;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class VolunteerRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private VolunteerProfileRequest profile;

    @Getter
    @Setter
    public static class VolunteerProfileRequest {
        private boolean hasOwnTransportation;
        private List<SkillRequest> skills;
        private LimitationRequest limitation;
        private VolunteerAvailabilityType availabilityType;
        private List<Weekday> availableDays;
        private String emergencyContactNumber;
    }

    @Getter
    @Setter
    public static class AvailabilityRequest {
        private VolunteerAvailabilityType availabilityType;
        private Set<Weekday> availableDays;
    }

    @Getter
    @Setter
    public static class SkillRequest {
        private int skillCode;
        private SkillLevel skillLevel;
    }

    @Getter
    @Setter
    public static class LimitationRequest {
        private boolean hasLimitation;
        private List<Integer> limitationCodes;
    }
}
