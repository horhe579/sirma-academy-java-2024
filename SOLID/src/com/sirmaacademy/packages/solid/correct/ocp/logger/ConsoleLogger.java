package com.sirmaacademy.packages.solid.correct.ocp.logger;

public class ConsoleLogger implements LoggingStrategy{

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
