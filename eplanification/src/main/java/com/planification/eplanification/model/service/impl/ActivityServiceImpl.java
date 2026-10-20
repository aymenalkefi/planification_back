package com.planification.eplanification.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planification.eplanification.dto.ActivityDto;
import com.planification.eplanification.dto.ActivitySearchCriteria;
import com.planification.eplanification.dto.PageResult;
import com.planification.eplanification.model.domain.Activity;
import com.planification.eplanification.model.repository.ActivityRepository;
import com.planification.eplanification.model.service.ActivityService;
import com.planification.eplanification.specification.ActivitySpecs;

import lombok.RequiredArgsConstructor;

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
    
    @Transactional(readOnly = true)
    public List<ActivityDto> search(ActivitySearchCriteria criteria) {
        return repository
                .findAll(ActivitySpecs.from(criteria), Sort.by("id"))
                .stream()
                .map(ActivityDto::from)
                .toList();
    }
    
    @Transactional(readOnly = true)
    public PageResult<ActivityDto> search(ActivitySearchCriteria criteria, Pageable pageable) {
        Page<Activity> page = repository.findAll(ActivitySpecs.from(criteria), pageable);
        return new PageResult<>(
                page.getContent().stream().map(ActivityDto::from).toList(),
                page.getTotalElements());
    }
}
