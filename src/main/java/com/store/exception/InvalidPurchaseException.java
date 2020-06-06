package com.store.exception;

public class InvalidPurchaseException extends RuntimeException {
    public InvalidPurchaseException() {
        super("Invalid purchase quantity");
    }
}
