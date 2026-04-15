package com.notas.notas.domains.grades.persistence.repositories;

import com.notas.notas.domains.grades.persistence.entities.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGradeRepository extends JpaRepository<GradeEntity, Long> {
    List<GradeEntity> findAllByStudentIdAndSubjectId(String studentId, Integer subjectId);
}
