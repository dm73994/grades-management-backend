package com.notas.notas.domains.subjects.dtos.response;

import java.time.LocalDateTime;

public record SubjectResDTO(
        Integer id,
        String name,
        String code,
        Integer credits,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
