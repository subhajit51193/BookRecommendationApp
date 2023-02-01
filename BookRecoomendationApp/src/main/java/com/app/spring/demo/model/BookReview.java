package com.app.spring.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "bookreview")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String review;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book", referencedColumnName = "id")
    private Book book;


}
