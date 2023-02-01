package com.app.spring.demo.service;

import com.app.spring.demo.model.Author;
import com.app.spring.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> getAllBookByAuthor(Author author);
    public Book saveBook(Book book);
    public Optional<Book> getBookById(Long id);
    public Book getBookByTitle(String title);
    public Book getBookByISBN(String ISBN);
    public Book updateBook(Long id, Book book);
    public void deleteBookById(Long id);


}
