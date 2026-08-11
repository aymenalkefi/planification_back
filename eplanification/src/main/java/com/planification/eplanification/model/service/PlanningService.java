package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Planning;
import java.util.List;
import java.util.Optional;

public interface PlanningService {
    List<Planning> findAll();
    Optional<Planning> findById(Long id);
    Planning save(Planning entity);
    Planning update(Long id, Planning entity);
    void deleteById(Long id);
}
