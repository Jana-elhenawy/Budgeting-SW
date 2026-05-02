package com.example.SW.Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Helper class for navigating between application screens.
 * Centralises all scene-switching logic so controllers stay clean.
 */
public class SceneManager {

    private static Stage primaryStage;

    private SceneManager() { }

    /**
     * Stores the application's primary stage for later navigation.
     *
     * @param stage the JavaFX primary stage
     */
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     * Switches the primary stage to the scene defined by the given FXML path.
     *
     * @param fxmlPath path relative to the com.example.SW resource folder,
     *                 e.g. "signup-view.fxml"
     * @throws IOException if the FXML file cannot be loaded
     */
    public static void switchTo(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource("/com/example/SW/" + fxmlPath)
        );
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
