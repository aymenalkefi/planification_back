package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.MonthOfSchool;
import com.planification.eplanification.model.repository.MonthOfSchoolRepository;
import com.planification.eplanification.model.service.MonthOfSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MonthOfSchoolServiceImpl implements MonthOfSchoolService {

    private final MonthOfSchoolRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<MonthOfSchool> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MonthOfSchool> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public MonthOfSchool save(MonthOfSchool entity) {
        return repository.save(entity);
    }

    @Override
    public MonthOfSchool update(Long id, MonthOfSchool entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("MonthOfSchool not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("MonthOfSchool not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
