package com.innofyre.rhcfs.dto;

import com.innofyre.rhcfs.model.DisasterStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisasterStatusUpdateRequest {
    private DisasterStatus status;
}
