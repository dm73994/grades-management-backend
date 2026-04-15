package com.notas.notas.domains.students.dtos.request;

import java.time.LocalDate;

public record UpdateStudentReqDTO(
        String name,
        String lastname,
        String email,
        LocalDate birthdate){
}
