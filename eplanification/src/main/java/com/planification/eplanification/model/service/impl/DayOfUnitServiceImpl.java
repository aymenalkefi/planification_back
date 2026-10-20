package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.DayOfUnit;
import com.planification.eplanification.model.repository.DayOfUnitRepository;
import com.planification.eplanification.model.service.DayOfUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DayOfUnitServiceImpl implements DayOfUnitService {

    private final DayOfUnitRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<DayOfUnit> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DayOfUnit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public DayOfUnit save(DayOfUnit entity) {
        return repository.save(entity);
    }

    @Override
    public DayOfUnit update(Long id, DayOfUnit entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("DayOfUnit not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("DayOfUnit not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
