package com.exercie.exercies.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> generateGeneralError(Exception e){
        return generateResponseError(e.getMessage(), "something went wrong", HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<?> generateResponseError(Object errors, String message, HttpStatus status){
        Map<String, Object> res = new HashMap<>();
        res.put("errors", errors);
        res.put("message", message);
        res.put("status", status.value());
        return new ResponseEntity<>(res, status);
    }

}
