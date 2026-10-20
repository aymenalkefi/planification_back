package com.planification.eplanification.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.planification.eplanification.dto.ActivitySearchCriteria;
import com.planification.eplanification.model.domain.Activity;

import jakarta.persistence.criteria.Predicate;

public final class ActivitySpecs {

    private ActivitySpecs() {}

    public static Specification<Activity> from(ActivitySearchCriteria c) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (c.id() != null) {
                predicates.add(cb.equal(root.get("id"), c.id()));
            }
            if (StringUtils.hasText(c.name())) {
                predicates.add(cb.like(cb.lower(root.get("name")),
                        "%" + c.name().trim().toLowerCase() + "%"));
            }
            if (StringUtils.hasText(c.description())) {
                predicates.add(cb.like(cb.lower(root.get("description")),
                        "%" + c.description().trim().toLowerCase() + "%"));
            }
            if (c.durationMin() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("durationMinutes"), c.durationMin()));
            }
            if (c.durationMax() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("durationMinutes"), c.durationMax()));
            }

            return cb.and(predicates.toArray(Predicate[]::new));
        };
    }
}