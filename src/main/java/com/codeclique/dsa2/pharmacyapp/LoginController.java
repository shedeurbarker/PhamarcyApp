package com.codeclique.dsa2.pharmacyapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public void forgotPasswordClicked() {
        // Implement logic to handle forgot password (e.g., display instructions)
        System.out.println("Forgot Password clicked!");
    }

    private MainController mainController; // Reference to MainController

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Register JDBC driver

            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Use the connection to perform authentication logic (explained later)

            connection.close(); // Close connection after use
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            // Handle driver class not found exception
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle connection errors
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}

