package com.app.spring.demo.payload.request;

import com.app.spring.demo.model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddBookRequest {
    private String title;
    private Author author;
    private String ISBN;
    private String description;

}
