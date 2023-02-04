package com.app.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name  = "author_id")
//    @JoinColumn(name = "author", referencedColumnName = "id")
    private Author author;

    private int reviewCount;
    @JsonManagedReference
    @OneToMany(mappedBy = "book")
//   @JoinColumn(name = "bookReview", referencedColumnName = "id") 
    private List<BookReview> bookReview;
    private int ratingCount;
    
    @ManyToOne
    @JoinColumn(name  = "id")
    private User user;


}
