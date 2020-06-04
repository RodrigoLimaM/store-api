package com.store.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("The password must have at least 8 characters");
    }
}
