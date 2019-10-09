package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private Set<Book> books = new HashSet<Book>(0);

    public Author() {
    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "id")},
    inverseJoinColumns = { @JoinColumn(name = "bookid")})
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public boolean hasBook(Book book) {
        for (Book authorBook: getBooks()) {
            if (authorBook.getBookid() == book.getBookid()) {
                return true;
            }
        }
        return false;
    }
}
