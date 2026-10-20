package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.WeekOfUnit;
import java.util.List;
import java.util.Optional;

public interface WeekOfUnitService {
    List<WeekOfUnit> findAll();
    Optional<WeekOfUnit> findById(Long id);
    WeekOfUnit save(WeekOfUnit entity);
    WeekOfUnit update(Long id, WeekOfUnit entity);
    void deleteById(Long id);
}
