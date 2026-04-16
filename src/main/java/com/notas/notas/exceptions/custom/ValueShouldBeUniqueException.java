package com.notas.notas.exceptions.custom;

public class ValueShouldBeUniqueException extends RuntimeException {
    private String message;
    public ValueShouldBeUniqueException(){}
    public ValueShouldBeUniqueException(String message) {
        super(message);
    }
}
