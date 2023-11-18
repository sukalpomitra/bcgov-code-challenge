package com.innofyre.rhcfs.helpers;

import com.innofyre.rhcfs.dto.VolunteerRequest;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class LimitationConverter implements AttributeConverter<VolunteerRequest.LimitationRequest , String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(VolunteerRequest.LimitationRequest limitation) {
        try {
            return objectMapper.writeValueAsString(limitation);
        } catch (Exception e) {
            throw new RuntimeException("Error converting Limitation to JSON", e);
        }
    }

    @Override
    public VolunteerRequest.LimitationRequest  convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, VolunteerRequest.LimitationRequest.class);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to Limitation", e);
        }
    }
}