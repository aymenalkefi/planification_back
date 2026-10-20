package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.MonthOfSchool;
import java.util.List;
import java.util.Optional;

public interface MonthOfSchoolService {
    List<MonthOfSchool> findAll();
    Optional<MonthOfSchool> findById(Long id);
    MonthOfSchool save(MonthOfSchool entity);
    MonthOfSchool update(Long id, MonthOfSchool entity);
    void deleteById(Long id);
}
