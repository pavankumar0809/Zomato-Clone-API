package com.example.zomato.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SimpleResponseStructure {

    private int status;
    private String message;

    public static SimpleResponseStructure create(HttpStatus status, String message) {
        SimpleResponseStructure responseStructure = new SimpleResponseStructure();
        responseStructure.setStatus(status.value());
        responseStructure.setMessage(message);
        return responseStructure;
    }
}
