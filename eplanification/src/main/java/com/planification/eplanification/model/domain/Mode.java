package com.planification.eplanification.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "mode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "mode", cascade = CascadeType.ALL)
    private List<Sessions> sessions;
}
