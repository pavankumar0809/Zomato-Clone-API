package com.example.zomato.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorStructure {
    private int status;
    private String message;
    private String rootCause;

    public static ErrorStructure create(HttpStatus status, String message, String rootCause) {
        ErrorStructure errorStructure = new ErrorStructure();
        errorStructure.setStatus(status.value());
        errorStructure.setMessage(message);
        errorStructure.setRootCause(rootCause);
        return errorStructure;
    }
}
