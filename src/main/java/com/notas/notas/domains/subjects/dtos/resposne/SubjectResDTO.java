package com.notas.notas.domains.subjects.dtos.resposne;

import java.time.LocalDateTime;

public record SubjectResDTO(
        int id,
        String name,
        String code,
        int credits,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
