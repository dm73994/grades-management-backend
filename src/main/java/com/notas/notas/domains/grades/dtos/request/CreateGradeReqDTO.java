package com.notas.notas.domains.grades.dtos.request;

public record CreateGradeReqDTO(
        Double value,
        String studentId,
        Integer subjectId
) {
}
