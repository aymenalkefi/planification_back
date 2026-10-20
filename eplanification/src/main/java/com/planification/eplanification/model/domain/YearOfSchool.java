package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "year_of_school")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YearOfSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private Integer yearNumber;

    private String startDate;

    private String endDate;

    @OneToMany(mappedBy = "yearOfSchool", cascade = CascadeType.ALL)
    private List<Sessions> sessions;
}
