package com.codeclique.dsa2.pharmacyapp.models;

/*
Arther: Anthony Barker
Description: This class represents a drug with its details and a list to store associated supplier IDs.
Date: 20th Jun, 2024
 */

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

public class Drug {
    private final String drugCode; // Unique identifier
    private final String name;
    private final String description;

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    private final double price;

    public String getDrugCode() {
        return drugCode;
    }

    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

//    public List<String> getSupplierIDs() {
//        return supplierIDs;
//    }
//
//    public void setSupplierIDs(List<String> supplierIDs) {
//        this.supplierIDs = supplierIDs;
//    }

//    public TreeMap<LocalDate, Purchase> getPurchaseHistory() {
//        return purchaseHistory;
//    }
//
//    public void setPurchaseHistory(TreeMap<LocalDate, Purchase> purchaseHistory) {
//        this.purchaseHistory = purchaseHistory;
//    }

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
}
