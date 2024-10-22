package com.example.zomato.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorStructure<T> {
    private int status;
    private String message;
    private T rootCause;

    public static <T>ErrorStructure<T> create(HttpStatus status, String message, T rootCause) {
        ErrorStructure<T> errorStructure = new ErrorStructure<T>();
        errorStructure.setStatus(status.value());
        errorStructure.setMessage(message);
        errorStructure.setRootCause(rootCause);
        return errorStructure;
    }
}
