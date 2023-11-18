package com.innofyre.rhcfs.exceptions;

import com.innofyre.rhcfs.dto.VolunteerRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class ValidationAspect {

  @Before("execution(* com.innofyre.rhcfs.controller.VolunteerController.*(..)) && args(volunteerRequest,..)")
  public void validateNonNullValues(JoinPoint joinPoint, VolunteerRequest volunteerRequest) {

    /**
     *
     * The validation liberty is not properly working, so added custom aspect for the fields validations for now
     */

    if (
      volunteerRequest.getFirstName() == null ||
      volunteerRequest.getLastName() == null ||
        volunteerRequest.getPhoneNumber() == null ||
        volunteerRequest.getEmail() == null
        || volunteerRequest.getDateOfBirth() == null
    ) {
      throw new ValidationException("FirstName, LastName, PhoneNumber, Email and DateOfBirth cannot be null");
    }
  }

  public boolean checkFieldsIsNull(Object instance, List<String> fieldNames) {

    return fieldNames.stream().allMatch(field -> {
      try {
        return Objects.isNull(instance.getClass().getDeclaredField(field).get(instance));
      } catch (IllegalAccessException | NoSuchFieldException e) {
        return true;
      }
    });
  }
}
