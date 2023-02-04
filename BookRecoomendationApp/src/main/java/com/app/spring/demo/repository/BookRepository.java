package com.app.spring.demo.repository;

import com.app.spring.demo.model.Author;
import com.app.spring.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
//    public List<Book> FindAllByBookByAuthor(Author author);
    public Book getBookByTitle(String title);
    public Book getBookByISBN(String ISBN);
    
    public List<Book> findByAuthor(Author author);
 
}
