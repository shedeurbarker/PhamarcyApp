package com.codeclique.dsa2.pharmacyapp;

import java.time.LocalDate;

public class Sale {
    private LocalDate saleDate;
    private String drugCode;
    private int quantitySold;
    private double totalPrice;
    private String customerID;

    // Getters and setters (omitted for brevity)

    public Sale(LocalDate saleDate, String drugCode, int quantitySold, double totalPrice, String customerID) {
        this.saleDate = saleDate;
        this.drugCode = drugCode;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
    }
}

