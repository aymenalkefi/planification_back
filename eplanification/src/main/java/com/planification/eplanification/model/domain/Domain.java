package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "domain")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degree_id", nullable = false)
    private Degree degree;

    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjects;
}
