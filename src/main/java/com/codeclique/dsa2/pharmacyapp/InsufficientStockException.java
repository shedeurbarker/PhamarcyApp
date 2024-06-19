package com.codeclique.dsa2.pharmacyapp;

public class InsufficientStockException extends Exception {

    public InsufficientStockException() {
        super("Insufficient stock available."); // Default message
    }

    public InsufficientStockException(String message) {
        super(message); // Allow custom message
    }
}
