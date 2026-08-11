package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Sessions;
import com.planification.eplanification.model.repository.SessionsRepository;
import com.planification.eplanification.model.service.SessionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionsServiceImpl implements SessionsService {

    private final SessionsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Sessions> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sessions> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Sessions save(Sessions entity) {
        return repository.save(entity);
    }

    @Override
    public Sessions update(Long id, Sessions entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Sessions not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Sessions not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
