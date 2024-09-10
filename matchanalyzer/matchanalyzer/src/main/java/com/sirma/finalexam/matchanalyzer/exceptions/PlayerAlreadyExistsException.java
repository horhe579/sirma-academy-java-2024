package com.sirma.finalexam.matchanalyzer.exceptions;

public class PlayerAlreadyExistsException extends RuntimeException{
    public PlayerAlreadyExistsException(String message) {
        super(message);
    }
}
