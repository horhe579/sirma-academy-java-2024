package com.sirma.finalexam.matchanalyzer.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String message) {
        super(message);
    }
}