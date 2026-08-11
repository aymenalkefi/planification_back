package com.planification.eplanification.model.service.impl;

import com.planification.eplanification.model.domain.Activity;
import com.planification.eplanification.model.repository.ActivityRepository;
import com.planification.eplanification.model.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Activity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Activity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Activity save(Activity entity) {
        return repository.save(entity);
    }

    @Override
    public Activity update(Long id, Activity entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Activity not found with id: " + id);
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Activity not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
