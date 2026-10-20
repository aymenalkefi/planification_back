package com.planification.eplanification.dto;

import java.util.List;

public record PageResult<T>(List<T> content, long totalElements) {}