package com.app.spring.demo.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookReviewRequest {
    private String bookReview;
    private String username;
    private String bookName;

}
