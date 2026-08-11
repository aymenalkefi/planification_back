package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Unit;
import java.util.List;
import java.util.Optional;

public interface UnitService {
    List<Unit> findAll();
    Optional<Unit> findById(Long id);
    Unit save(Unit entity);
    Unit update(Long id, Unit entity);
    void deleteById(Long id);
}
