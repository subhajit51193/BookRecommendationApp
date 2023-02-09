package com.app.spring.demo.repository;

import com.app.spring.demo.model.Author;
import com.app.spring.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);
    Book findBookByTitle(String title);
    Book findBookByISBN(String ISBN);
}
