package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantNotFoundByIdException extends RuntimeException {
    private String message;

}
