package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Sessions;
import java.util.List;
import java.util.Optional;

public interface SessionsService {
    List<Sessions> findAll();
    Optional<Sessions> findById(Long id);
    Sessions save(Sessions entity);
    Sessions update(Long id, Sessions entity);
    void deleteById(Long id);
}
