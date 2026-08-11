package com.planification.eplanification.model.repository;

import com.planification.eplanification.model.domain.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository extends JpaRepository<Mode, Long> {
}
