package com.notas.notas.domains.students.dtos.response;

import java.time.LocalDate;

public record StudentResDTO(
        String id,
        String name,
        String lastname,
        String email,
        LocalDate birthdate,
        int age
) {
}
