package com.sirma.classes.exceptions;

public class NoEmployeesException extends RuntimeException{
    public NoEmployeesException(String message) {
        super(message);
    }
}
