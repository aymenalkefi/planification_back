package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "planning")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String academicYear;

    private String status;

    @OneToMany(mappedBy = "planning", cascade = CascadeType.ALL)
    private List<Unit> units;

    @OneToMany(mappedBy = "planning", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sessions> sessions;
}
