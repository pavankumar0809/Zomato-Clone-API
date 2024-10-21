package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.util.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantExceptionHandler {
    @ExceptionHandler(RestaurantNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure> handleRestaurantNotFoundByID(RestaurantNotFoundByIdException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND,ex.getMessage(),"Restaurant not available with given restaurantId"));
    }
}
