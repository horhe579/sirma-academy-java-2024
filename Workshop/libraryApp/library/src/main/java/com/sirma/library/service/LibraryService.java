package com.sirma.library.service;

import com.sirma.library.model.Book;
import com.sirma.library.model.Magazine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private CsvService csvService;

    public List<Book> getBooks()
    {
        return csvService.readBooks();
    }

//    public List<Magazine> getMagazines()
//    {
//        return csvService.readMagazines();
//    }

    public void addBook(Book book)
    {
        csvService.saveBook(book);
    }

//    public boolean addMagazine(Magazine magazine)
//    {
//        return csvService.saveMagazine(magazine);
//    }



}
