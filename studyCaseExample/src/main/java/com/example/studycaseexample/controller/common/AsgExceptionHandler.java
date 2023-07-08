package com.example.studycaseexample.controller.common;

import com.example.studycaseexample.exception.AsgDataNotFoundException;

import com.example.studycaseexample.exception.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AsgExceptionHandler {
    @ExceptionHandler(AsgDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleDataNotFoundException(AsgDataNotFoundException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception e) {
        return new ExceptionResponse(ExceptionType.GENERIC_EXCEPTION, e.getMessage());
    }
}
