package com.codeclique.dsa2.pharmacyapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        MainController controller = fxmlLoader.getController(); // Get reference to the controller


        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Pharmacy Management System");
        stage.setScene(scene);
        stage.show();

        // Set the DrugManager instance in the controller (explained later)
        controller.setDrugManager(new DrugManager()); // Create and inject DrugManager

    }

    public static void main(String[] args) {
        launch(args);
    }

}