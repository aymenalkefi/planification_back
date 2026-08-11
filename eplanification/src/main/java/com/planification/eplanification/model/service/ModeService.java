package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Mode;
import java.util.List;
import java.util.Optional;

public interface ModeService {
    List<Mode> findAll();
    Optional<Mode> findById(Long id);
    Mode save(Mode entity);
    Mode update(Long id, Mode entity);
    void deleteById(Long id);
}
