package com.app.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @Column(name = "description", nullable = false)
    private String description;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="authorId", referencedColumnName = "id")
    private Author author;

    private int reviewCount;
    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookReview> bookReview;
    private int ratingCount;


}
