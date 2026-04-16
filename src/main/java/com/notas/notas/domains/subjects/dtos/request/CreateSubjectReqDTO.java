package com.notas.notas.domains.subjects.dtos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateSubjectReqDTO(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El código es obligatorio")
        String code,
        @PositiveOrZero(message = "Los créditos deben ser un número positivo o cero")
        @Max(value = 20, message = "Los créditos no pueden ser mayores a 20")
        @NotNull(message = "Los créditos son obligatorios")
        Integer credits
) {
}
