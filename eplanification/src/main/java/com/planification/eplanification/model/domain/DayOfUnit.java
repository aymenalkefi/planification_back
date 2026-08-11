package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "day_of_unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayOfUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer dayNumber;

    @OneToMany(mappedBy = "dayOfUnit", cascade = CascadeType.ALL)
    private List<Sessions> sessions;
}
