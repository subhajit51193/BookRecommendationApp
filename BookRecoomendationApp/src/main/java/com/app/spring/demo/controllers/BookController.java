package com.app.spring.demo.controllers;

import com.app.spring.demo.model.Author;
import com.app.spring.demo.model.Book;
import com.app.spring.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookController {
    private BookService bookService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(BookController.class);

    @PostMapping("/books")
    public Book saveBook(@Valid @RequestBody Book book) {
        LOGGER.info("within saveBook of BookController");
        return bookService.saveBook(book);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getAllBookByAuthor(@PathVariable("author") Author author){
        LOGGER.info("within getAllBookByAuthor of BookController");
        return bookService.getAllBookByAuthor(author);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        LOGGER.info("within updateBook of BookController");
        return bookService.updateBook(id,book);
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id){
        LOGGER.info("within getBookById of BookController");
        return bookService.getBookById(id);
    }

    @GetMapping("/books/{title}")
    public Book getBookByTitle(@PathVariable("title") String title){
        LOGGER.info("within getBookByTitle of BookController");
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/books/{ISBN}")
    public Book getBookByISBN(@PathVariable("ISBN") String ISBN){
        LOGGER.info("within getBookByISBN of BookController");
        return bookService.getBookByISBN(ISBN);
    }
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "Book deleted Successfully!!";
    }

}
