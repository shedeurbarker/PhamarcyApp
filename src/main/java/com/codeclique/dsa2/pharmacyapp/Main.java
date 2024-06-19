package com.codeclique.dsa2.pharmacyapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainController mainController = new MainController();
        LoginController loginController = new LoginController();

        loginController.setPrimaryStage(primaryStage);
        loginController.setMainController(mainController); // Connect controllers

        mainController.showLoginPage(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }

}