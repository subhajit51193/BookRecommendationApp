package com.app.spring.demo.exception;

public class BookAlreadyExistException extends RuntimeException{
    private String message;

    public BookAlreadyExistException(String message) {
        this.message = message;
    }
}
