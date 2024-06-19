package com.codeclique.dsa2.pharmacyapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrugManager {
    private final HashMap<String, Drug> drugs;

    public DrugManager() {
        drugs = new HashMap<>();
    }

    public void addDrug(String drugCode, String name, String description, double price, int stockLevel) {

        Drug newDrug = new Drug(drugCode, name, description, price, stockLevel);
        drugs.put(drugCode, newDrug);
    }

    public List<Drug> searchDrugs(String searchTerm) {
        List<Drug> results = new ArrayList<>();
        for (Drug drug : drugs.values()) {
            if (drug.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    drug.getDrugCode().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(drug);
            }
        }
        return results;
    }

    public List<Drug> getAllDrugs() {
        return new ArrayList<>(drugs.values()); // Return a copy of the drug values
    }

    public void recordSale(String drugCode, int quantity) throws InsufficientStockException {
        Drug drug = drugs.get(drugCode);
        if (drug == null) {
            throw new IllegalArgumentException("Drug not found: " + drugCode);
        }
        if (drug.getStockLevel() < quantity) {
            throw new InsufficientStockException("Insufficient stock for " + drugCode);
        }
        drug.setStockLevel(drug.getStockLevel() - quantity);
        // Add logic to record sale details (e.g., date, customer, price)
    }

    public List<String> getInventoryReport() {
        List<String> report = new ArrayList<>();
        for (Drug drug : drugs.values()) {
            report.add(drug.getDrugCode() + " - " + drug.getName() + " (" + drug.getStockLevel() + " in stock)");
        }
        return report;
    }

    public void recordSale(String drugCode, int quantity, String customerID) throws InsufficientStockException {
        Drug drug = drugs.get(drugCode);
        if (drug == null) {
            throw new IllegalArgumentException("Drug not found: " + drugCode);
        }
        if (drug.getStockLevel() < quantity) {
            throw new InsufficientStockException("Insufficient stock for " + drugCode);
        }
        drug.setStockLevel(drug.getStockLevel() - quantity);

        // Calculate total price based on drug price and quantity
        double totalPrice = drug.getPrice() * quantity;

        Sale newSale = new Sale(LocalDate.now(), drugCode, quantity, totalPrice, customerID); // Replace with your method to get customer ID
        // (Optional) Add the Sale object to a list or data structure for future reference
//        salesList.add(newSale); // Assuming you have a list to store sales
    }

}

