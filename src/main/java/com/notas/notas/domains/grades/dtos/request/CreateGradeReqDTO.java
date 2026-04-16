package com.notas.notas.domains.grades.dtos.request;

import jakarta.validation.constraints.*;

public record CreateGradeReqDTO(
        @Digits(integer = 1, fraction = 2, message = "La nota debe ser un número con hasta 1 dígito entero y 2 dígitos decimales")
        @Max(value = 5, message = "La nota no puede ser mayor a 5")
        @PositiveOrZero(message = "La nota debe ser un número positivo o cero")
        Double value,
        @NotBlank(message = "El id del estudiante no puede estar vacío")
        String studentId,
        @NotNull(message = "El id de la materia no puede estar vacío")
        Integer subjectId
) {
}
