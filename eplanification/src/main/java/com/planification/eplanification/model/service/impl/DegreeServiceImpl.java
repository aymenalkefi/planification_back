package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Degree;
import com.planification.eplanification.model.repository.DegreeRepository;
import com.planification.eplanification.model.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DegreeServiceImpl implements DegreeService {

    private final DegreeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Degree> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Degree> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Degree save(Degree entity) {
        return repository.save(entity);
    }

    @Override
    public Degree update(Long id, Degree entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Degree not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Degree not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
