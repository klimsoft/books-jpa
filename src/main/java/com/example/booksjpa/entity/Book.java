package com.example.booksjpa.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long id;
    String title;
    String author;
    int publisded;
    @Version
    long version;

    public Book(){

    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublisded() {
        return publisded;
    }

    public void setPublisded(int publisded) {
        this.publisded = publisded;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
