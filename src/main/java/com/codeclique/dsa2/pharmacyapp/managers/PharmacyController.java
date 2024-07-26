package com.codeclique.dsa2.pharmacyapp.managers;

//import javafx.collections.FXCollections;//new
//import javafx.collections.ObservableList;//new

import com.codeclique.dsa2.pharmacyapp.InsufficientStockException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//import javafx.scene.control.cell.PropertyValueFactory;//new
//import javafx.scene.control.TableColumn;//new
//import javafx.scene.control.TableView;//new

import java.net.URL;
import java.util.ResourceBundle;

public class PharmacyController implements Initializable {
    @FXML
    private TextField customerIDField;

    @FXML
    private TextField drugCodeField; // Assuming you have a TextField for drug code
    @FXML
    private TextField quantityField; // Assuming you have a TextField for quantity

    private DrugManager drugManager; // Instance of DrugManager class (injected or created)
    @FXML
    private Button searchButton;

//    @FXML
//    private TableView<Drug> drugTableView;//new
//    @FXML
//    private TableColumn<Drug, String> drugCodeColumn;
//    @FXML
//    private TableColumn<Drug, String> drugNameColumn;
//    @FXML
//    private TableColumn<Drug, Integer> quantityColumn;
//    @FXML
//    private TableColumn<Drug, Double> priceColumn;
//
//    private ObservableList<Drug> drugList;//new


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//y

        searchButton.setOnAction(event -> searchDrug()); // Add event listener for search button
    }
    private void searchDrug() {
        // Implement logic to search for drug based on drug code
        String drugCode = drugCodeField.getText();
//        Drug drug = (Drug) drugManager.searchDrugs(drugCode);
//        if (drug != null){
//            drugList.clear();
//            drugList.add(drug);}
//        else{
//            System.out.println("Drug not found");
//        }

        // ... (search logic) ...
    }
    //

    public void recordSale() {
        String drugCode = drugCodeField.getText(); // Retrieve drug code from UI
        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText()); // Convert quantity to int (handle exceptions)
        } catch (NumberFormatException e) {
            // Display error message if quantity is not a valid number
            System.out.println("Invalid quantity format. Please enter a number.");
            return; // Exit the method if quantity is invalid
        }

        try {
            drugManager.recordSale(drugCode, quantity, getCustomerIDFromUI()); // Pass retrieved customer ID
        } catch (InsufficientStockException e) {
            // Display error message if there's insufficient stock
            System.out.println("Insufficient stock for " + drugCode);
        }

        // (Optional) Clear UI fields after successful sale recording
        drugCodeField.clear();
        quantityField.clear();
    }

    public String getCustomerIDFromUI() {
        if (customerIDField != null) {
            String enteredCustomerID = customerIDField.getText().trim();
            // Optional validation (check for empty string or specific format)
            if (enteredCustomerID.isEmpty()) {
                // Display error message (optional)
                System.out.println("Please enter a customer ID.");
                return ""; // Return empty string or default value if validation fails
            }
            return enteredCustomerID;
        } else {
            // Handle case where customerIDField is not injected properly
            System.out.println("Error: customer ID field not found in FXML.");
            return ""; // Return empty string or default value if field is missing
        }
    }
}

