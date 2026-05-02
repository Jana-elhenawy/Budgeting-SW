package com.example.SW.Controller;

import com.example.SW.Util.SceneManager;
import com.example.SW.Util.UserSession;
import com.example.SW.Util.UserStore;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller for the Sign-Up screen (User Story #1).
 *
 * Responsibilities:
 *   - Validate that no field is empty.
 *   - Validate that the email contains "@".
 *   - Validate that the password meets minimum requirements.
 *   - Validate that both password fields match.
 *   - Register the new user via UserStore.
 *   - On success, set up the UserSession and navigate to the main screen.
 *   - On failure, display a descriptive error message.
 */
public class SignUpController {

    @FXML private TextField     fullNameField;
    @FXML private TextField     emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label         statusLabel;

    /**
     * Called when the user clicks "Create Account".
     * Validates input, registers the user, then navigates to the transaction view.
     */
    @FXML
    private void handleCreateAccount() {
        // --- Read inputs ---
        String fullName        = fullNameField.getText().trim();
        String email           = emailField.getText().trim();
        String password        = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // --- Validate: no empty fields ---
        if (fullName.isEmpty() || email.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()) {
            showError("All fields are required.");
            return;
        }

        // --- Validate: email format ---
        if (!email.contains("@") || !email.contains(".")) {
            showError("Please enter a valid email address.");
            return;
        }

        // --- Validate: password strength (min 8 chars) ---
        if (password.length() < 8) {
            showError("Password must be at least 8 characters.");
            return;
        }

        // --- Validate: passwords match ---
        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match.");
            return;
        }

        // --- Register the user ---
        boolean registered = UserStore.register(fullName, email, password);
        if (!registered) {
            showError("An account with this email already exists.");
            return;
        }

        // --- Create session and navigate to main view ---
        UserSession.login(fullName, email);

        try {
            SceneManager.switchTo("transaction-controller.fxml");
        } catch (IOException e) {
            showError("Could not load the main screen.");
        }
    }

    /**
     * Navigates to the Login screen when "Already have an account? Log in" is clicked.
     */
    @FXML
    private void handleGoToLogin() {
        try {
            SceneManager.switchTo("login-view.fxml");
        } catch (IOException e) {
            showError("Could not load the login screen.");
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
