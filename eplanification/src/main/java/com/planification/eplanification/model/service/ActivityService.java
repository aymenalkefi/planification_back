package com.planification.eplanification.model.service;

import com.planification.eplanification.dto.ActivityDto;
import com.planification.eplanification.dto.ActivitySearchCriteria;
import com.planification.eplanification.dto.PageResult;
import com.planification.eplanification.model.domain.Activity;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface ActivityService {
    List<Activity> findAll();
    Optional<Activity> findById(Long id);
    Activity save(Activity entity);
    Activity update(Long id, Activity entity);
    void deleteById(Long id);
    public List<ActivityDto> search(ActivitySearchCriteria criteria) ;
    public PageResult<ActivityDto> search(ActivitySearchCriteria criteria, Pageable pageable);
}
