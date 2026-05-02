package com.example.SW;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("transaction-controller.fxml")
        );
        Scene scene = new Scene(loader.load());
        stage.setTitle("BudgetWise");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}