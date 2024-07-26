package com.codeclique.dsa2.pharmacyapp.managers;

import com.codeclique.dsa2.pharmacyapp.models.Supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SupplierManager {
    private HashMap<String, Supplier> suppliers;

    public SupplierManager() {
        suppliers = new HashMap<>();
    }

    // Add a supplier
    public void addSupplier(String supplierID, String name, String location, String contactInfo) {
        Supplier newSupplier = new Supplier(supplierID, name, location, contactInfo);
        suppliers.put(supplierID, newSupplier);
    }

    // Search suppliers based on a search term (name or location)
    public List<Supplier> searchSuppliers(String searchTerm) {
        List<Supplier> results = new ArrayList<>();
        for (Supplier supplier : suppliers.values()) {
            if (supplier.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    supplier.getLocation().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(supplier);
            }
        }
        return results;
    }

    // Get all suppliers
    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers.values()); // Return a copy of the supplier values
    }

    // Get a supplier by ID (optional)
    public Supplier getSupplier(String supplierID) {
        return suppliers.get(supplierID);
    }
}
