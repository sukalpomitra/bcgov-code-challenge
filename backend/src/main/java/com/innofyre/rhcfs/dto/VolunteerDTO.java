package com.innofyre.rhcfs.dto;

import com.innofyre.rhcfs.model.SkillLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolunteerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String gender;
    private VolunteerProfileDTO profile;
    private int score;
    public boolean hasSkill(int skillCode, SkillLevel skillLevel) {
        return profile.getSkills()
                .stream().anyMatch(s -> s.getSkillCode() == skillCode && s.getSkillLevel() == skillLevel);
    }
}


