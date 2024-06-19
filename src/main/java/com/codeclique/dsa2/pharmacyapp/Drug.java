package com.codeclique.dsa2.pharmacyapp;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

public class Drug {
    private String drugCode; // Unique identifier
    private String name;
    private String description;

    public double getPrice() {
        return price;
    }

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    private int stockLevel;
    private List<String> supplierIDs; // List of supplier IDs

    private TreeMap<LocalDate, Purchase> purchaseHistory; // New member variable

    public Drug(String drugCode, String name, String description, double price, int stockLevel) {
        this.drugCode = drugCode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    // Method to add a purchase record
    public void addPurchase(LocalDate purchaseDate, int quantity, double amount, String customerID) {
        purchaseHistory.put(purchaseDate, new Purchase(quantity, amount, customerID));
    }

    // Method to link a supplier to the drug
    public void addSupplier(String supplierID) {
        if (!supplierIDs.contains(supplierID)) { // Check for duplicate IDs
            supplierIDs.add(supplierID);
        }
    }

    public int getStockLevel() {
        return stockLevel;
    }
}
