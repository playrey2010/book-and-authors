package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;
    @Column(name = "booktitle")
    private String title;
    @ManyToMany(mappedBy = "books")
    private Set<Author>  authors;
    private String description;
    private double price;
    private boolean isInStock;

    // constructor(s)
    public Book() {}

    public Book(String title, Set<Author>  authors, String description) {
        this.title = title;
        this.authors = authors;
        this.description = description;
    }

    public Book(String title, Set<Author>  authors, String description, double price) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.price = price;
    }

    // special methods
    public long getBookid() {
        return bookid;
    }


    public String getDisplayText() {
        return title + " was written by " + authors + "\n" + description;
    }
    // getters and setters


    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

}
