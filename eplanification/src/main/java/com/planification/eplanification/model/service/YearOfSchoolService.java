package com.planification.eplanification.model.service;

import com.planification.eplanification.model.domain.YearOfSchool;
import java.util.List;
import java.util.Optional;

public interface YearOfSchoolService {
    List<YearOfSchool> findAll();
    Optional<YearOfSchool> findById(Long id);
    YearOfSchool save(YearOfSchool entity);
    YearOfSchool update(Long id, YearOfSchool entity);
    void deleteById(Long id);
}
