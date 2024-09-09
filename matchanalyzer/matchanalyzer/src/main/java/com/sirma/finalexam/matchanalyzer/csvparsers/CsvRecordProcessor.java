package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;

import java.io.IOException;
import java.util.List;

public class CsvRecordProcessor implements CsvParser<Record> {
    @Override
    public void parseCsv(String fileName) throws IOException {
        return ;
    }

    @Override
    public Record parseEntry(String csvLine) {
        return null;
    }

    @Override
    public void saveBatch(List<Record> entries) {

    }
}
