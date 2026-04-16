package com.notas.notas.domains.students.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CreateStudentReqDTO(
        @NotBlank(message = "El id no puede estar vacío")
        String id,
        @NotBlank(message = "El nombre no puede estar vacío")
        String name,
        @NotBlank(message = "El apellido no puede estar vacío")
        String lastname,
        @NotBlank(message = "El email no puede estar vacío")
        @Email(message = "El email debe ser válido")
        String email,
        @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
        LocalDate birthdate
) {
}
