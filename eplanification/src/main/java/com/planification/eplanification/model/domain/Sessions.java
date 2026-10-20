package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String startTime;

    private String endTime;

    private Integer durationMinutes;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planning_id", nullable = false)
    private Planning planning;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_of_school_id")
    private YearOfSchool yearOfSchool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_of_school_id")
    private MonthOfSchool monthOfSchool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "week_of_unit_id")
    private WeekOfUnit weekOfUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_of_unit_id")
    private DayOfUnit dayOfUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mode_id")
    private Mode mode;
}
