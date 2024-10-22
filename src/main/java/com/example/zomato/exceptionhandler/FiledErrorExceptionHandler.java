package com.example.zomato.exceptionhandler;

import com.example.zomato.util.ErrorStructure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FiledErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ObjectError> errors = ex.getAllErrors();
        List<FieldErrorStructure> errorResponse = new ArrayList<>();

        errors.forEach(error -> {
            FieldError fr = (FieldError) error;
            String message = fr.getDefaultMessage();
            String field = fr.getField();
            Object rejectedValue = fr.getRejectedValue();
            FieldErrorStructure fieldErrorStructure = new FieldErrorStructure(message, field, rejectedValue);
            errorResponse.add(fieldErrorStructure);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorStructure.create(HttpStatus.BAD_REQUEST, "invalid input", errorResponse));
    }

    @AllArgsConstructor
    @Getter
    class FieldErrorStructure {
        private String message;
        private String field;
        private Object rejectedValue;

    }

}
