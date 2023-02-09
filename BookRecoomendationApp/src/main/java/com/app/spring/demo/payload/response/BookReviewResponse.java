package com.app.spring.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookReviewResponse {
    private String message;
    private String bookReview;

}
