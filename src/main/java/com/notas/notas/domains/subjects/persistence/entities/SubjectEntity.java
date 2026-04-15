package com.notas.notas.domains.subjects.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Column(nullable = false, unique = true, length = 100, name = "nombre")
    private String name;

    @Column(nullable = false, unique = true, length = 10, name = "codigo")
    private String code;

    @Column(nullable = false, name = "creditos")
    private Integer credits;

    @Builder.Default
    @Column(nullable = false, name = "fecha_registro")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(nullable = false, name = "fecha_actualizacion")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
