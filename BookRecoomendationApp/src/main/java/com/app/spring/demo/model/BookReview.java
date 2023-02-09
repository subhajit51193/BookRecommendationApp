package com.app.spring.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "bookreview")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String review;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;


}
