package com.planification.eplanification.model.repository;

import com.planification.eplanification.model.domain.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
