package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Subject;
import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();
    Optional<Subject> findById(Long id);
    Subject save(Subject entity);
    Subject update(Long id, Subject entity);
    void deleteById(Long id);
}
