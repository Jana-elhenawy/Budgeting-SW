package com.example.SW;

import com.example.SW.Util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX application entry point.
 * Registers the primary stage with SceneManager and opens the Login screen.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BudgetWise");
        stage.setResizable(false);
        SceneManager.setPrimaryStage(stage);
        // Start at the login screen so US#1 and US#2 are exercised first
        SceneManager.switchTo("login-view.fxml");
    }
}
