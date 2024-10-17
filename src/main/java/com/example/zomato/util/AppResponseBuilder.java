package com.example.zomato.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppResponseBuilder {

    public <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data){
        return  ResponseEntity.status(status).body(ResponseStructure.create(status, message, data));
    }
}
