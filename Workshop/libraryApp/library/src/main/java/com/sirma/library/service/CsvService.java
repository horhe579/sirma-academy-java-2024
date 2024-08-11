package com.sirma.library.service;

import com.sirma.library.model.Book;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvService {

    private static final String BOOKS_FILE = "C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\Workshop\\libraryApp\\library\\src\\main\\resources\\books.csv";
    private static final String MAGAZINES_FILE = "C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\Workshop\\libraryApp\\library\\src\\main\\resources\\magazines.csv";

    public List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] fields = Arrays.stream(line.split(",")).map(x -> x.trim()).toArray(String[]::new);
                Book book = new Book(
                        fields[0],
                        fields[1],
                        Integer.parseInt(fields[2]),
                        fields[3]);

                books.add(book);
            }

            return books;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void saveBook(Book book)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE, true))) {
            writer.write(book.toString());
            writer.newLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
