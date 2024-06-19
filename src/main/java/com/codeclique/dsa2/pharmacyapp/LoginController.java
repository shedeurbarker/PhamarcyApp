package com.codeclique.dsa2.pharmacyapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane mainPane; // Reference to the main pane in FXML
    @FXML
    private TextField usernameField; // Username input field
    @FXML
    private PasswordField passwordField; // Password input field
    @FXML
    private Button loginButton; // Login button

    private String jdbcURL = "jdbc:mysql://localhost:3306/phamarcyApp"; // Replace with your details
    private String jdbcUsername = "phamD"; // Replace with your database credentials
    private String jdbcPassword = "3l1*jWXgVRD*Jh6j";
    private Stage primaryStage; // Reference to the main application stage
    public void forgotPasswordClicked() {
        // Implement logic to handle forgot password (e.g., display instructions)
        System.out.println("Forgot Password clicked!");
    }

    private MainController mainController; // Reference to MainController

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {

            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?"); // Replace with your table and column names
            statement.setString(1, username); // Set username parameter
            statement.setString(2, password); // Set password parameter (hashed password recommended)

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Login successful (user found)
                System.out.println("Login successful!");
                mainController.loginSuccessful(primaryStage);
                // Replace with actions after successful login (e.g., show main app)
            } else {
                // Login failed (user not found or invalid password)
                System.out.println("Login failed!");
                // Display error message to user
            }

            connection.close(); // Close connection after use
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle connection errors
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

