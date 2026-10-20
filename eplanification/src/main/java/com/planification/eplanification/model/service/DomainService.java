package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Domain;
import java.util.List;
import java.util.Optional;

public interface DomainService {
    List<Domain> findAll();
    Optional<Domain> findById(Long id);
    Domain save(Domain entity);
    Domain update(Long id, Domain entity);
    void deleteById(Long id);
}
