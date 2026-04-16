package com.notas.notas.domains.students.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdateStudentReqDTO(
        String name,
        String lastname,
        @Email
        String email,
        @Past
        LocalDate birthdate){
}
