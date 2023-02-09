package com.app.spring.demo.payload.response;

import com.app.spring.demo.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class BookListResponse {
    private String message;
    private LocalDateTime timeStamp;
    private List<Book> bookList = null;
}
