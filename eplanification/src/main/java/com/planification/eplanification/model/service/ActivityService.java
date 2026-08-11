package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.Activity;
import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<Activity> findAll();
    Optional<Activity> findById(Long id);
    Activity save(Activity entity);
    Activity update(Long id, Activity entity);
    void deleteById(Long id);
}
