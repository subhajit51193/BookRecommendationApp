package com.app.spring.demo.controllers;

import com.app.spring.demo.exception.BookAlreadyExistException;
import com.app.spring.demo.exception.BookNotFoundException;
import com.app.spring.demo.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class ExceptionControler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookAlreadyExistException.class)
    public ResponseEntity<Object> bookAlreadyExistException(BookAlreadyExistException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage() , HttpStatus.FORBIDDEN);
        return  new ResponseEntity<>(exceptionResponse , HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> bookNotFoundException(BookNotFoundException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage() , HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(exceptionResponse , HttpStatus.NOT_FOUND);
    }
}
