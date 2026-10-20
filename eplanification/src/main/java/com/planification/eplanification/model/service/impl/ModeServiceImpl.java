package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Mode;
import com.planification.eplanification.model.repository.ModeRepository;
import com.planification.eplanification.model.service.ModeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModeServiceImpl implements ModeService {

    private final ModeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Mode> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Mode> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mode save(Mode entity) {
        return repository.save(entity);
    }

    @Override
    public Mode update(Long id, Mode entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Mode not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Mode not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
