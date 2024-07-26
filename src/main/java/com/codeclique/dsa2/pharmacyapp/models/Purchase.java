/*
This class represents a purchase record with details
like date, quantity, amount, and optional customer information.
 */

package com.codeclique.dsa2.pharmacyapp.models;

public class Purchase {
    private int quantity; // Purchased quantity

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount; // Total amount paid
    private String customerID; // Customer identifier

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Purchase(int quantity, double amount, String customerID) {
        this.quantity = quantity;
        this.amount = amount;
        this.customerID = customerID;
    }
}

