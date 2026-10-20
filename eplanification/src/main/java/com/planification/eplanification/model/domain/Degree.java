package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "degree")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domain> domains;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Level> levels;
}
