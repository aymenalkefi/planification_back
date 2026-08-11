package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Degree;
import java.util.List;
import java.util.Optional;

public interface DegreeService {
    List<Degree> findAll();
    Optional<Degree> findById(Long id);
    Degree save(Degree entity);
    Degree update(Long id, Degree entity);
    void deleteById(Long id);
}
