package com.sirmaacademy.packages.solid.correct.srp;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
    }

    public UUID getID()
    {
        return this.id;
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

    @Override
    public String toString() {
        return '\'' + title + '\'' + " by " + author;
    }
}
