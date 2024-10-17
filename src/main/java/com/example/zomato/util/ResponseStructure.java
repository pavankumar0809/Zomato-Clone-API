package com.example.zomato.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;

    public static  <T> ResponseStructure<T> create(HttpStatus status, String message, T data){
        ResponseStructure<T> responseStructure= new ResponseStructure<>();
        responseStructure.setStatus(status.value());
        responseStructure.setMessage(message);
        responseStructure.setData(data);
        return  responseStructure;
    }
}
