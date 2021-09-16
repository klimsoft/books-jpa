package com.example.booksjpa.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    long id;
    String title;
    String author;
    int publisded;

    public Book( String title, String author, int publisded) {
        this.title = title;
        this.author = author;
        this.publisded = publisded;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisded=" + publisded +
                '}';
    }
}
