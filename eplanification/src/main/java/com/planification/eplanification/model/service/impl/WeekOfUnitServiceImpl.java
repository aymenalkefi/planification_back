package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.WeekOfUnit;
import com.planification.eplanification.model.repository.WeekOfUnitRepository;
import com.planification.eplanification.model.service.WeekOfUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class WeekOfUnitServiceImpl implements WeekOfUnitService {

    private final WeekOfUnitRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<WeekOfUnit> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<WeekOfUnit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public WeekOfUnit save(WeekOfUnit entity) {
        return repository.save(entity);
    }

    @Override
    public WeekOfUnit update(Long id, WeekOfUnit entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("WeekOfUnit not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("WeekOfUnit not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
