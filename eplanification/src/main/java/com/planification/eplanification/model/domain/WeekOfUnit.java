package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "week_of_unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeekOfUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private Integer weekNumber;

    @OneToMany(mappedBy = "weekOfUnit", cascade = CascadeType.ALL)
    private List<Sessions> sessions;
}
