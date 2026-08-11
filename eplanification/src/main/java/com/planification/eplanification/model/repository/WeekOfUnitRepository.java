package com.planification.eplanification.model.repository;

import com.planification.eplanification.model.domain.WeekOfUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekOfUnitRepository extends JpaRepository<WeekOfUnit, Long> {
}
