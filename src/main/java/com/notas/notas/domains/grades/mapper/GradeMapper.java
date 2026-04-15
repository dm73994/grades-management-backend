package com.notas.notas.domains.grades.mapper;

import com.notas.notas.domains.grades.dtos.request.CreateGradeReqDTO;
import com.notas.notas.domains.grades.dtos.resposne.GradeResDTO;
import com.notas.notas.domains.grades.persistence.entities.GradeEntity;
import com.notas.notas.domains.students.persistence.entities.StudentEntity;
import com.notas.notas.domains.subjects.persistence.entities.SubjectEntity;

public class GradeMapper {
    public static GradeEntity toEntityFrom(CreateGradeReqDTO request) {
        return GradeEntity.builder()
                .value(request.value())
                .student(
                        StudentEntity.builder().id(request.studentId()).build()
                )
                .subject(
                        SubjectEntity.builder().id(request.subjectId()).build()
                )
                .build();
    }

    public static GradeResDTO toResponseFrom(GradeEntity entity) {
        return new GradeResDTO(
                entity.getId(),
                entity.getValue(),
                entity.getStudent().getId(),
                entity.getSubject().getId(),
                entity.getCreatedAt()
        );
    }
}
