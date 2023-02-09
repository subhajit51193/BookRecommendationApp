package com.app.spring.demo.exception;

public class BookNotFoundException extends RuntimeException{
    private String message;

    public BookNotFoundException(String message) {
        this.message = message;
    }
}
