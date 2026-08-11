package com.planification.eplanification.model.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planification.eplanification.model.service.ModuleService;
import com.planification.eplanification.model.domain.Module;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/business/Modules")
public class ModuleController {
	
	 private final ModuleService service;
	 
	   @Autowired
	    public ModuleController(ModuleService service) {
	        this.service = service;
	    }
	   
	   
	   
	   @PostMapping("/create")
	    public Module create(@RequestBody @Valid Module entity , HttpServletRequest request) {

	        return service.save(entity,request);
	    }

}
