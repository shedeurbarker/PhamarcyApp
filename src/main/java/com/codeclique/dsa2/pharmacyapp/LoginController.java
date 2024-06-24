package com.codeclique.dsa2.pharmacyapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Label errorMessageLabel;
    DBQueries qbQueries = new DBQueries();

    public void loginButtonClicked() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()) {
            errorMessageLabel.setText("Enter Username or Password to continue!");
            errorMessageLabel.setVisible(true); // Make the label visible
            return;
        }
        try {
            // Database credentials

            Connection connection = qbQueries.openConnection();
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Login successful (user found)
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("phamarcy.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();

            } else {
                // Login failed (user not found or invalid password)
                errorMessageLabel.setText("Invalid username or password!");
                errorMessageLabel.setVisible(true); // Make the label visible
            }

            connection.close(); // Close connection after use
        } catch (SQLException | IOException e) {
            errorMessageLabel.setText("Unknown error occurred. Retry!");
            errorMessageLabel.setVisible(true); // Make the label visible
        }
    }
}

