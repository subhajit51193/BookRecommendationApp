package com.app.spring.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bookreviews")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;
    private String username;
    private String review;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name  = "book_id")
//    @JoinColumn(name = "book", referencedColumnName = "book_id")
    private Book book;


}
