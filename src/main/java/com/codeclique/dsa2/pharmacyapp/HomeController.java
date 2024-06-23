package com.codeclique.dsa2.pharmacyapp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML private GridPane buttonGrid;
    private DrugManager drugManager; // Reference to DrugManager instance

    @FXML private TextField drugCodeField;
    @FXML private TextField nameField;
    @FXML private TextArea descriptionField;
    @FXML private TextField priceField;
    @FXML private TextField stockLevelField;
    @FXML private Button addDrugButton;
    @FXML private Button logoutButton;

    public void initialize() {
        logoutButton.setOnAction(event -> {
            try {
                logoutButtonClicked();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void logoutButtonClicked() throws IOException {
// logout and load login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setDrugManager(DrugManager drugManager) {
        this.drugManager = drugManager;
    }

    public void addDrug() {
            // Get user input from text fields
            String drugCode = drugCodeField.getText();
            String name = nameField.getText();
            String description = descriptionField.getText();
            double price = Double.parseDouble(priceField.getText()); // Convert to double
            int stockLevel = Integer.parseInt(stockLevelField.getText()); // Convert to int
        // Call DrugManager's addDrug method
        drugManager.addDrug(drugCode, name, description, price, stockLevel);

         // Clear input fields or display success message
            drugCodeField.clear();
            nameField.clear();
            descriptionField.clear();
            priceField.clear();
            stockLevelField.clear();
        //    // Alternatively, display a success message

    }

}
