package com.saar.saar.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResouceNotFoundException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("message", ex.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }
}
