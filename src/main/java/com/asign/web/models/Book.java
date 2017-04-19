package com.asign.web.models;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Alex on 4/11/2017.
 */
@Component
@XmlRootElement(name = "SingleBook")
public class Book {

    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private int quantity;
    private double price;

    public Book(String title, String author, String genre, String ISBN, int quantity, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.quantity = quantity;
        this.price = price;
    }

    public Book() {
    }

    public boolean isNew(){
        return(this.ISBN == null);
    }

    @XmlElement(name ="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement(name = "ISBN")
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    @XmlElement(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (quantity != book.quantity) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        if (!genre.equals(book.genre)) return false;
        return ISBN.equals(book.ISBN);
    }

}
