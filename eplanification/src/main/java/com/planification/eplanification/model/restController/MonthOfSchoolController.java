package com.planification.eplanification.model.restController;

import com.planification.eplanification.model.domain.MonthOfSchool;
import com.planification.eplanification.model.service.MonthOfSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/month-of-schools")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MonthOfSchoolController {

    private final MonthOfSchoolService service;

    @GetMapping
    public ResponseEntity<List<MonthOfSchool>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthOfSchool> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MonthOfSchool> create(@RequestBody MonthOfSchool entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonthOfSchool> update(@PathVariable Long id, @RequestBody MonthOfSchool entity) {
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
}
