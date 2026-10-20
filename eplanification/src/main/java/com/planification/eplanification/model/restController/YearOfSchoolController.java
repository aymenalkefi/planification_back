package com.planification.eplanification.model.restController;

import com.planification.eplanification.model.domain.YearOfSchool;
import com.planification.eplanification.model.service.YearOfSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/year-of-schools")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class YearOfSchoolController {

    private final YearOfSchoolService service;

    @GetMapping
    public ResponseEntity<List<YearOfSchool>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<YearOfSchool> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<YearOfSchool> create(@RequestBody YearOfSchool entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<YearOfSchool> update(@PathVariable Long id, @RequestBody YearOfSchool entity) {
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
