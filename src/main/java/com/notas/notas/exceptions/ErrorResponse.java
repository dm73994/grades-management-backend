package com.notas.notas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int code;
    private Object message;

    public ErrorResponse(Object message) {
        super();
        this.message = message;
    }
}
