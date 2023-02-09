package com.app.spring.demo.controllers;

import com.app.spring.demo.payload.request.AddBookRequest;
import com.app.spring.demo.payload.response.BookResponse;
import com.app.spring.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RequestMapping(value="/api")
public class BookController {
    private BookService bookService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(BookController.class);

    @PostMapping("/books")
    public ResponseEntity<BookResponse> saveBook(@Valid @RequestBody AddBookRequest book) {
        LOGGER.info("within saveBook of BookController");
        return new ResponseEntity<>(bookService.saveBook(book), CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id, @RequestBody AddBookRequest book) {
        LOGGER.info("within updateBook of BookController");
        return new ResponseEntity<>(bookService.updateBook(id,book), OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") Long id){
        LOGGER.info("within getBookById of BookController");
        return new ResponseEntity<>(bookService.getBookById(id), OK);
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<BookResponse> getBookByTitle(@PathVariable("title") String title){
        LOGGER.info("within getBookByTitle of BookController");
        return new ResponseEntity<>(bookService.getBookByTitle(title), OK);
    }

    @GetMapping("/books/{ISBN}")
    public ResponseEntity<BookResponse> getBookByISBN(@PathVariable("ISBN") String ISBN){
        LOGGER.info("within getBookByISBN of BookController");
        return new ResponseEntity<>(bookService.getBookByISBN(ISBN), OK);
    }
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "Book deleted Successfully!!";
    }

}
