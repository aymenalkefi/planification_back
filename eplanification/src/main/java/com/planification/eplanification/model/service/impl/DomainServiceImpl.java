package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Domain;
import com.planification.eplanification.model.repository.DomainRepository;
import com.planification.eplanification.model.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DomainServiceImpl implements DomainService {

    private final DomainRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Domain> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Domain> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Domain save(Domain entity) {
        return repository.save(entity);
    }

    @Override
    public Domain update(Long id, Domain entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Domain not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Domain not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
