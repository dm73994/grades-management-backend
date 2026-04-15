package com.notas.notas.domains.subjects.persistence.repositories;

import com.notas.notas.domains.subjects.persistence.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    boolean existsById(String id);
    boolean existsByName(String name);
    boolean existsByCode(String code);
}
