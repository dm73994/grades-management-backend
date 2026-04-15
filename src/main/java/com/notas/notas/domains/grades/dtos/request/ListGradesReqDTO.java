package com.notas.notas.domains.grades.dtos.request;

public record ListGradesReqDTO(
        String studentId,
        Integer subjectId
) {
}
