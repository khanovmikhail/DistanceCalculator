package com.khanovmikhail.distancecalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    ResponseEntity<ExceptionResponse> noCityInDBHandler(NoCityInDBException exception){
        ExceptionResponse data = new ExceptionResponse();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<ExceptionResponse> exHandler(Exception exception){
        ExceptionResponse data = new ExceptionResponse();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
