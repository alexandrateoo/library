package com.asign.web.service;

import com.asign.web.models.Book;

import java.util.List;

/**
 * Created by Alex on 4/17/2017.
 */
public interface BookServices {

    boolean existsBook(Book book);

    void addBook(Book book);

    void deleteBook(Book book);

    int getBookQuantity(Book book);

    Book getBookInfo(String isbn);

    List<Book> getAllBooksGenre(String genre);

    List<Book> getAllBooksTitle(String title);

    List<Book> getAllBooksAuthor(String author);

    List<Book> getAllBooks();
}
