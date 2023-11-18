package com.innofyre.rhcfs.dto;

import com.innofyre.rhcfs.model.SkillLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO {
    private Long id;
    private int skillCode;
    private SkillLevel skillLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkillDTO skillDTO = (SkillDTO) o;

        if (skillCode != skillDTO.skillCode) return false;
        return skillLevel == skillDTO.skillLevel;
    }

    @Override
    public int hashCode() {
        int result = skillCode;
        result = 31 * result + skillLevel.getValue();
        return result;
    }
}