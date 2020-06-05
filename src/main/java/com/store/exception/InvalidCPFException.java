package com.store.exception;

public class InvalidCPFException extends RuntimeException {

    public InvalidCPFException(){
        super("Invalid CPF");
    }
}
