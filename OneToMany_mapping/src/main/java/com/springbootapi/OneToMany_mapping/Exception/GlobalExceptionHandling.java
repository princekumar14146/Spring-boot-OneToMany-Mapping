package com.springbootapi.OneToMany_mapping.Exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {


    @ExceptionHandler(DataAlreadyPresentException.class)
    public ResponseEntity<String > handleDataAlreadyPresentException(DataAlreadyPresentException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> handleConstraintsViolationException(ConstraintViolationException ex)
    {
        Map<String,String> errors=new HashMap<>();
        ex.getConstraintViolations().forEach((error)->{
            String fieldName=error.getPropertyPath().toString();
            String errorMessage=error.getMessage();

            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(DataNotPresentException.class)
    public ResponseEntity<String> handleDataNotPresentException(DataNotPresentException ex)
    {
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
