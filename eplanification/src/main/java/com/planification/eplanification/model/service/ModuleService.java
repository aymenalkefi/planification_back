package com.planification.eplanification.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planification.eplanification.model.repository.ModuleRepository;

import jakarta.servlet.http.HttpServletRequest;

import com.planification.eplanification.model.domain.Module;


@Service
public class ModuleService {

	
	private final ModuleRepository repository;
	
	@Autowired
	public ModuleService(ModuleRepository repository) {
	    this.repository = repository;
	}
	
	
	public Module save(Module entity, HttpServletRequest request) {

	
	    entity.setEtatBD(true);
	    return repository.save(entity);
	}
	
}
