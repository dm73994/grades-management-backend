package com.notas.notas.domains.subjects.persistence.entities;

import com.notas.notas.domains.grades.persistence.entities.GradeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "materias")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, name = "nombre")
    private String name;

    @Column(nullable = false, unique = true, name = "codigo")
    private String code;

    @Column(nullable = false, name = "creditos")
    private Integer credits;

    @Builder.Default
    @Column(nullable = false, name = "fecha_registro")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(nullable = false, name = "fecha_actualizacion")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GradeEntity> grades;
}
