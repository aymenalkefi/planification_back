package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "month_of_school")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthOfSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer monthNumber;

    @OneToMany(mappedBy = "monthOfSchool", cascade = CascadeType.ALL)
    private List<Sessions> sessions;
}
