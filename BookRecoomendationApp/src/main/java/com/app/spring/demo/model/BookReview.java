package com.app.spring.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "bookreview")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String review;


}
