package com.app.spring.demo.service.implementation;

import com.app.spring.demo.model.Author;
import com.app.spring.demo.model.Book;
import com.app.spring.demo.repository.BookRepository;
import com.app.spring.demo.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServiceImplementation implements BookService {
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public List<Book> getAllBookByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        return bookRepository.getBookByISBN(ISBN);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
