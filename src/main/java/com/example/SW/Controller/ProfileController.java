package com.example.SW.Controller;

import com.example.SW.Util.SceneManager;
import com.example.SW.Util.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ProfileController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private ComboBox<String> currencyBox;
    @FXML private ComboBox<String> languageBox;
    @FXML private CheckBox notificationCheck;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        currencyBox.getItems().addAll("USD", "EUR", "EGP");
        languageBox.getItems().addAll("English", "Arabic");
        loadUserData();
    }

    private void loadUserData() {
        nameField.setText(UserSession.getName());
        emailField.setText(UserSession.getEmail());
        currencyBox.setValue(UserSession.getCurrency());
        languageBox.setValue(UserSession.getLanguage());
        notificationCheck.setSelected(UserSession.isNotificationsEnabled());
    }

    @FXML
    private void handleSave() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            statusLabel.setText("Name cannot be empty.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        UserSession.setName(name);
        UserSession.setCurrency(currencyBox.getValue());
        UserSession.setLanguage(languageBox.getValue());
        UserSession.setNotifications(notificationCheck.isSelected());

        statusLabel.setText("Profile saved successfully!");
        statusLabel.setStyle("-fx-text-fill: green;");
    }
    @FXML
    private void handleBackToDashboard() throws IOException {
        SceneManager.switchTo("dashboard.fxml");
    }
}