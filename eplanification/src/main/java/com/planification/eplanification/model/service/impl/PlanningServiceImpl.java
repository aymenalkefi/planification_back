package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Planning;
import com.planification.eplanification.model.repository.PlanningRepository;
import com.planification.eplanification.model.service.PlanningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PlanningServiceImpl implements PlanningService {

    private final PlanningRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Planning> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Planning> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Planning save(Planning entity) {
        return repository.save(entity);
    }

    @Override
    public Planning update(Long id, Planning entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Planning not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Planning not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
