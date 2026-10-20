package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.YearOfSchool;
import com.planification.eplanification.model.repository.YearOfSchoolRepository;
import com.planification.eplanification.model.service.YearOfSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class YearOfSchoolServiceImpl implements YearOfSchoolService {

    private final YearOfSchoolRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<YearOfSchool> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<YearOfSchool> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public YearOfSchool save(YearOfSchool entity) {
        return repository.save(entity);
    }

    @Override
    public YearOfSchool update(Long id, YearOfSchool entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("YearOfSchool not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("YearOfSchool not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
