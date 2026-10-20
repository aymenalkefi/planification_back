package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Unit;
import com.planification.eplanification.model.repository.UnitRepository;
import com.planification.eplanification.model.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UnitServiceImpl implements UnitService {

    private final UnitRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Unit> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Unit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Unit save(Unit entity) {
        return repository.save(entity);
    }

    @Override
    public Unit update(Long id, Unit entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Unit not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Unit not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
