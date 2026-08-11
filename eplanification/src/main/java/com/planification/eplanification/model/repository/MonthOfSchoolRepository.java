package com.planification.eplanification.model.repository;

import com.planification.eplanification.model.domain.MonthOfSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthOfSchoolRepository extends JpaRepository<MonthOfSchool, Long> {
}
