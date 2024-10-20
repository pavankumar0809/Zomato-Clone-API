package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.AddressCannotAddedException;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@AllArgsConstructor
@RestControllerAdvice
public class AddressExceptionHandler {
    private final AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(AddressCannotAddedException.class)
    public ResponseEntity<ErrorStructure> handleAddressNotAdded(AddressCannotAddedException ex){
            return appResponseBuilder.error(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), "Address already present");
    }
}
