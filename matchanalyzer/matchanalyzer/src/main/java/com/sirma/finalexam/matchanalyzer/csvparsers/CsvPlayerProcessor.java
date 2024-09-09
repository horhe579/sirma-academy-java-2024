package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.entities.Player;
import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;

import java.io.IOException;
import java.util.List;

public class CsvPlayerProcessor implements CsvParser<Player> {
    @Override
    public void parseCsv(String fileName) throws IOException {
        return;
    }

    @Override
    public Player parseEntry(String csvLine) {
        return null;
    }

    @Override
    public void saveBatch(List<Player> entries) {

    }
}
