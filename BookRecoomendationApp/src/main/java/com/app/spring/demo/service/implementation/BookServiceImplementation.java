package com.app.spring.demo.service.implementation;

import com.app.spring.demo.exception.BookAlreadyExistException;
import com.app.spring.demo.exception.BookNotFoundException;
import com.app.spring.demo.model.Book;
import com.app.spring.demo.payload.request.AddBookRequest;
import com.app.spring.demo.payload.response.BookResponse;
import com.app.spring.demo.repository.BookRepository;
import com.app.spring.demo.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServiceImplementation implements BookService {
    private BookRepository bookRepository;

    @Override
    public BookResponse saveBook(AddBookRequest book) throws BookAlreadyExistException {
        Book existingBook = bookRepository.findBookByTitle(book.getTitle());
        if (existingBook != null) {
            throw new BookAlreadyExistException("Book Already exist");
        }else{
            Book newBook = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setISBN(book.getISBN());
            newBook.setAuthor(book.getAuthor());
            newBook.setDescription(book.getDescription());
            return new BookResponse("success", LocalDateTime.now(), newBook);
        }
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        if (foundBook != null) {
            return new BookResponse("success", LocalDateTime.now(), foundBook);
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public BookResponse getBookByTitle(String title) {
        Book foundBook = bookRepository.findBookByTitle(title);
        if (foundBook != null) {
            return new BookResponse("success", LocalDateTime.now(), foundBook);
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public BookResponse getBookByISBN(String ISBN) {
        Book foundBook = bookRepository.findBookByISBN(ISBN);
        if (foundBook != null) {
            return new BookResponse("success", LocalDateTime.now(), foundBook);
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public BookResponse updateBook(Long id, AddBookRequest book) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        if(foundBook != null){
            foundBook.setTitle(book.getTitle());
            foundBook.setISBN(book.getISBN());
            foundBook.setAuthor(book.getAuthor());
            foundBook.setDescription(book.getDescription());
            bookRepository.save(foundBook);
            return new BookResponse("success" , LocalDateTime.now() , foundBook);
        }else{
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
