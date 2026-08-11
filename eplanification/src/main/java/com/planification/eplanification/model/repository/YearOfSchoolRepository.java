package com.planification.eplanification.model.repository;

import com.planification.eplanification.model.domain.YearOfSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearOfSchoolRepository extends JpaRepository<YearOfSchool, Long> {
}
