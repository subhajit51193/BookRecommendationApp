package com.app.spring.demo.service;

import com.app.spring.demo.payload.request.AddBookRequest;
import com.app.spring.demo.payload.response.BookListResponse;
import com.app.spring.demo.payload.response.BookResponse;


public interface BookService {

    //Optional<BookListResponse> getAllBookByAuthor(Author author);
    BookResponse saveBook(AddBookRequest book);
    BookResponse getBookById(Long id);
    BookResponse getBookByTitle(String title);
    BookResponse getBookByISBN(String ISBN);
    BookResponse updateBook(Long id, AddBookRequest book);
    void deleteBookById(Long id);


}
