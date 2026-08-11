package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Level;
import com.planification.eplanification.model.repository.LevelRepository;
import com.planification.eplanification.model.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LevelServiceImpl implements LevelService {

    private final LevelRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Level> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Level> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Level save(Level entity) {
        return repository.save(entity);
    }

    @Override
    public Level update(Long id, Level entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Level not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Level not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
