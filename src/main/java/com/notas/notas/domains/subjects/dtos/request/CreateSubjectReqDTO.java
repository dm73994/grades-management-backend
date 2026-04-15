package com.notas.notas.domains.subjects.dtos.request;

public record CreateSubjectReqDTO(
        String name,
        String code,
        int credits
) {
}
