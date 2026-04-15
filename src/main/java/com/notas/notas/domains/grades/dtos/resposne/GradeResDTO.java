package com.notas.notas.domains.grades.dtos.resposne;

import java.time.LocalDateTime;

public record GradeResDTO(
        Long id,
        Double value,
        String studentId,
        Integer subjectId,
        LocalDateTime createdAt
) {
}
