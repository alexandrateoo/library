package com.asign.web.models;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/11/2017.
 */
@Component
@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.NONE)
public class BookList {

    @XmlElement(name = "book")
    private List<Book> bookList;

    public BookList(){
        bookList = new ArrayList<Book>();
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
