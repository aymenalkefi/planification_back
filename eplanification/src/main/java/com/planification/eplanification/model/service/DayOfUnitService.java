package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.DayOfUnit;
import java.util.List;
import java.util.Optional;

public interface DayOfUnitService {
    List<DayOfUnit> findAll();
    Optional<DayOfUnit> findById(Long id);
    DayOfUnit save(DayOfUnit entity);
    DayOfUnit update(Long id, DayOfUnit entity);
    void deleteById(Long id);
}
