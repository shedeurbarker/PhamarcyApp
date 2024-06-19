package com.codeclique.dsa2.pharmacyapp;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private DrugManager drugManager; // Reference to DrugManager instance

    @FXML
    private TextField drugCodeField;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField stockLevelField;
    @FXML
    private Button addDrugButton;

    @FXML
    private Label welcomeText;

    private Stage primaryStage; // Reference to the main application stage


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void showLoginPage() {
        try {
            // Load login FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent loginPage = loader.load();

            // Show login scene
            Scene loginScene = new Scene(loginPage);
            primaryStage.setScene(loginScene);
            primaryStage.show();

        } catch (Exception e) {
            // Handle loading exceptions
        }
    }

    // Placeholder for handling successful login
    public void loginSuccessful() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main_app.fxml")); // Replace with your main app FXML file name
            Parent mainApp = loader.load();
            // Show main app scene
            Scene mainScene = new Scene(mainApp);
            primaryStage.setScene(mainScene);

        } catch (Exception e) {
            // Handle loading exceptions
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
