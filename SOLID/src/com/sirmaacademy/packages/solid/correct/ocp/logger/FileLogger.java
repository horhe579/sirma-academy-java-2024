package com.sirmaacademy.packages.solid.correct.ocp.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggingStrategy{

    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try(BufferedWriter br = new BufferedWriter(new FileWriter(filename, true))){
            br.write(message);
            br.newLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
