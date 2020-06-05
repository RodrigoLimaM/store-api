package com.store.exception;

public class InvalidDateException extends RuntimeException {

    public InvalidDateException(){
        super("Invalid date");
    }
}
