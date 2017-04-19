package com.asign.web.service;

import com.asign.web.jaxb.BookJaxb;
import com.asign.web.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/17/2017.
 */

@Service("bookservice")
public class BookServiceImpl implements BookServices {
    @Autowired
    private BookJaxb bookJaxb;
    private List<Book> allBooks = getAllBooks();


    public boolean existsBook(Book book) {
        for (Book b : allBooks)
            if (b.getISBN().equals(book.getISBN()))
                return true;
        return false;
    }

    public void addBook(Book book) {

        if (getBookInfo(book.getISBN()) != null)
            updateBook(book);

        if (book.getISBN().length() == 13 && book.getAuthor() != null
                && book.getGenre() != null && book.getPrice() > 0 && book.getQuantity() > 0
                && book.getTitle() != null && !existsBook(book)) {
            allBooks = getAllBooks();
            allBooks.add(book);
            bookJaxb.marshallList(allBooks);
        }
    }

    private void updateBook(Book book) {
        Book newBook = new Book(book.getTitle(), book.getAuthor(),
                book.getGenre(), book.getISBN(), book.getQuantity(), book.getPrice());
        allBooks.remove(book);
        allBooks.add(newBook);
        bookJaxb.marshallList(allBooks);
    }

    public void deleteBook(Book book) {
        if (existsBook(book)) {
            allBooks.remove(book);
            bookJaxb.marshallList(allBooks);
        }
    }

    public int getBookQuantity(Book book) {
        for (Book b : allBooks)
            if (b.getISBN().equals(book.getISBN()))
                return book.getQuantity();
        return 0;
    }

    public Book getBookInfo(String ISBN) {
        for (Book b : allBooks)
            if (b.getISBN().equals(ISBN))
                return b;
        return null;
    }

    public List<Book> getAllBooksGenre(String genre) {
        List<Book> genreBook = new ArrayList<Book>();
        for (Book b : allBooks)
            if (b.getGenre().contains(genre))
                genreBook.add(b);
        return genreBook;
    }

    public List<Book> getAllBooksTitle(String title) {
        List<Book> titleBooks = new ArrayList<Book>();
        for(Book b:allBooks)
            if(b.getTitle().equals(title))
                titleBooks.add(b);
        return titleBooks;
    }

    public List<Book> getAllBooksAuthor(String author) {
        List<Book> authorBooks = new ArrayList<Book>();
        for(Book b:allBooks)
            if(b.getAuthor().equals(author))
                authorBooks.add(b);
        return authorBooks;
    }

    public List<Book> getAllBooks() {
        bookJaxb = new BookJaxb();
        return bookJaxb.unmarshallList();
    }
}
