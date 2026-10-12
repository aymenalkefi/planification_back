package com.planification.eplanification.dto;

import com.planification.eplanification.model.domain.Activity;

public record ActivityDto(
        Long id,
        String name,
        String description,
        Integer durationMinutes) {

    public static ActivityDto from(Activity a) {
        return new ActivityDto(
                a.getId(),
                a.getName(),
                a.getDescription(),
                a.getDurationMinutes());
    }
}