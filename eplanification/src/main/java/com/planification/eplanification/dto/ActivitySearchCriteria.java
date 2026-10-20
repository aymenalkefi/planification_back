package com.planification.eplanification.dto;

public record ActivitySearchCriteria(
        Long id,
        String name,
        String description,
        Integer durationMin,
        Integer durationMax) {}