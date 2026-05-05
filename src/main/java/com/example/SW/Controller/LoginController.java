package com.example.SW.Controller;

import com.example.SW.Model.User;
import com.example.SW.Util.SceneManager;
import com.example.SW.Util.UserSession;
import com.example.SW.Util.UserStore;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller for the Login screen (User Story #2).
 *
 * Responsibilities:
 *   - Validate that neither email nor password is blank.
 *   - Authenticate against the UserStore (in-memory user registry).
 *   - On success, populate UserSession and navigate to the main screen.
 *   - On failure, display the error message required by the SRS:
 *     "Invalid email or password. Please try again."
 */
public class LoginController {

    @FXML private TextField     emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label         statusLabel;

    /**
     * Called when the user clicks "Log In".
     * Validates credentials and navigates to the main view on success.
     */
    @FXML
    private void handleLogin() {
        String email    = emailField.getText().trim();
        String password = passwordField.getText();

        // --- Validate: no empty fields ---
        if (email.isEmpty() || password.isEmpty()) {
            showError("Please enter your email and password.");
            return;
        }

        // --- Authenticate ---
        User user = UserStore.authenticate(email, password);
        if (user == null) {
            showError("Invalid email or password. Please try again.");
            return;
        }

        // --- Create session and navigate ---
        UserSession.login(user.getFullName(), user.getEmail());

        try {
            SceneManager.switchTo("dashboard.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            showError("Could not load the main screen.");
        }
    }

    /**
     * Navigates to the Sign-Up screen when "Don't have an account? Sign Up" is clicked.
     */
    @FXML
    private void handleGoToSignUp() {
        try {
            SceneManager.switchTo("signup-view.fxml");
        } catch (IOException e) {
            showError("Could not load the sign-up screen.");
        }
    }

    // -----------------------------------------------------------------------
    // Private helpers
    // -----------------------------------------------------------------------

    private void showError(String message) {
        statusLabel.setStyle("-fx-text-fill: red;");
        statusLabel.setText(message);
    }
}
