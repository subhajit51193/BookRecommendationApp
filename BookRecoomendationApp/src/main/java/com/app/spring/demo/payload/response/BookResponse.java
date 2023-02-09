package com.app.spring.demo.payload.response;

import com.app.spring.demo.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class BookResponse {
    private String message;
    private LocalDateTime timeStamp;
    private Book book;

}
