package com.notas.notas.domains.students.persistence.repositories;

import com.notas.notas.domains.students.persistence.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentPersistenceRepository extends JpaRepository<StudentEntity, String> {
}
