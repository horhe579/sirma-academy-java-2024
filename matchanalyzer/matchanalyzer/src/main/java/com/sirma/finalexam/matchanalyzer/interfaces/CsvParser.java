package com.sirma.finalexam.matchanalyzer.interfaces;

import java.io.IOException;
import java.util.List;

public interface CsvParser<T> {
    void parseCsv(String fileName) throws IOException;

    T parseEntry(String csvLine);

    void saveBatch(List<T> entries);
}
