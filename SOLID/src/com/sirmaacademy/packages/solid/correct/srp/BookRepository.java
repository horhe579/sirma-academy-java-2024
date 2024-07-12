package com.sirmaacademy.packages.solid.correct.srp;

import java.util.UUID;

public class BookRepository {

    public void saveToDatabase(Book book)
    {
        System.out.println("Saving " + book.getTitle() + " by " + book.getAuthor() + "to database.");
    }

    public String getBookSummary(Book book)
    {
        return book.toString();
    }

    public void findBookInDatabase(UUID bookId)
    {
        System.out.println("Looking for book with id " + bookId.toString() + " in database.");
    }

}
