package com.codeclique.dsa2.pharmacyapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainController mainController = new MainController();
        LoginController loginController = new LoginController();

        mainController.setPrimaryStage(primaryStage);
        loginController.setMainController(mainController); // Connect controllers

        mainController.showLoginPage();
    }

    public static void main(String[] args) {
        launch();
    }

}

// DB pass: 3l1*jWXgVRD*Jh6j
// DB User: phamD