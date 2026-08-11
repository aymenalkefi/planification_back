package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Subject;
import com.planification.eplanification.model.repository.SubjectRepository;
import com.planification.eplanification.model.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subject> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Subject save(Subject entity) {
        return repository.save(entity);
    }

    @Override
    public Subject update(Long id, Subject entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Subject not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Subject not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
