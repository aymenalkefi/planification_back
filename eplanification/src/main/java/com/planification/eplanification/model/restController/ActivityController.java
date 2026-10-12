package com.planification.eplanification.model.restController;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planification.eplanification.dto.ActivityDto;
import com.planification.eplanification.dto.ActivitySearchCriteria;
import com.planification.eplanification.dto.PageResult;
import com.planification.eplanification.model.domain.Activity;
import com.planification.eplanification.model.service.ActivityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ActivityController {

	private final ActivityService service;

	@GetMapping
	public ResponseEntity<List<Activity>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Activity> getById(@PathVariable Long id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Activity> create(@RequestBody Activity entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Activity> update(@PathVariable Long id, @RequestBody Activity entity) {
		try {
			return ResponseEntity.ok(service.update(id, entity));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/search")
    public List<ActivityDto> search(ActivitySearchCriteria criteria) {
        return service.search(criteria);
    }
	
	@GetMapping("/search/page")
	public PageResult<ActivityDto> search(
	        ActivitySearchCriteria criteria,
	        @PageableDefault(size = 10, sort = "id") Pageable pageable) {
	    return service.search(criteria, pageable);
	}
}
