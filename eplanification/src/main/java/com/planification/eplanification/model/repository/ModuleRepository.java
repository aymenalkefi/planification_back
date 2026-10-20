package com.planification.eplanification.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.planification.eplanification.model.domain.Module;

@Repository
public interface ModuleRepository extends JpaRepository <Module, Long> {

}
