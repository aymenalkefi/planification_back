package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Level;
import java.util.List;
import java.util.Optional;

public interface LevelService {
    List<Level> findAll();
    Optional<Level> findById(Long id);
    Level save(Level entity);
    Level update(Long id, Level entity);
    void deleteById(Long id);
}
