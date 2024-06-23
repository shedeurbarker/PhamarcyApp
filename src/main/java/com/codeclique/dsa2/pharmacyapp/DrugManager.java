package com.codeclique.dsa2.pharmacyapp;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrugManager {
    private final HashMap<String, Drug> drugs;
    private final DBQueries dbQueries = new DBQueries();

    public DrugManager() {
        drugs = new HashMap<>();
    }

    public boolean addDrug(Drug newDrug) throws SQLException {
        // save new drug added into database
        Connection connection = dbQueries.openConnection();
        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO drugs SET drugCode = ?, name = ?, description = ?, price = ?, stockLevel = ?, date = ?");
        statement.setString(1, newDrug.getDrugCode());
        statement.setString(2, newDrug.getName());
        statement.setString(3, newDrug.getDescription());
        statement.setDouble(4, newDrug.getPrice());
        statement.setInt(5, newDrug.getStockLevel());
        statement.setDate(6, Date.valueOf(LocalDate.now()));

        // execute statement
        ResultSet result = dbQueries.queryDB(statement);
        if(result.next()) {
            // successfully added to database - add drug to stack
            drugs.put(newDrug.getDrugCode(), newDrug);
            return true;
            // ! todo - implement UI update
        }
        else {
            // ! todo - implement UI error alert
            System.out.println("to be replaced by a visual response");
        }
        return false;
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

    // ! todo to be called by main controller to display all drugs
    public void getAllDrugs() {
        try {
            // Connect to the database
            Connection connection = dbQueries.openConnection();
            String sql = "SELECT * FROM drugs";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executing the query and store the results in a ResultSet
            ResultSet resultSet = dbQueries.queryDB(statement);

            // Loop through the results and create a list of Drug objects
            while (resultSet.next()) {
                String drugCode = resultSet.getString("drugCode");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int stockLevel = resultSet.getInt("stockLevel");

                // create drug objects from data fetched from db and add to list
                Drug drug = new Drug(drugCode, name, description, price, stockLevel);
                drugs.put(drugCode, drug);
            }
            connection.close();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }

    public void recordSale(String drugCode, int quantity, String customerID) throws InsufficientStockException {
        Drug drug = drugs.get(drugCode);
        if (drug == null) {
            // ! todo replace with UI response
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

    public List<String> getInventoryReport() {
        List<String> report = new ArrayList<>();
        for (Drug drug : drugs.values()) {
            report.add(drug.getDrugCode() + " - " + drug.getName() + " (" + drug.getStockLevel() + " in stock)");
        }
        return report;
    }

}

