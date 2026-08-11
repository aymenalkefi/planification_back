package com.planification.eplanification.model.repository;

import com.planification.eplanification.model.domain.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionsRepository extends JpaRepository<Sessions, Long> {
}
