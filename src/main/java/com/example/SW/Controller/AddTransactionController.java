package com.example.SW.Controller;

import com.example.SW.Model.Transaction;
import com.example.SW.Util.SceneManager;
import com.example.SW.Util.TransactionSession;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller for the Add Transaction screen (User Story #3).
 *
 * Responsibilities:
 *   - Let the user toggle between "Income" and "Expense".
 *   - Collect amount, category, description, and date.
 *   - Validate that the amount is a positive number and category is selected.
 *   - Save the transaction via TransactionSession.
 *   - Navigate back to the transaction list on success.
 *   - Show inline error messages matching the SRS exceptional scenario.
 */
public class AddTransactionController {

    @FXML private ToggleButton   incomeToggle;
    @FXML private ToggleButton   expenseToggle;
    @FXML private TextField      amountField;
    @FXML private ComboBox<String> categoryBox;
    @FXML private TextField      descriptionField;
    @FXML private DatePicker     datePicker;
    @FXML private Label          statusLabel;

    /**
     * Called automatically by JavaFX after FXML injection.
     * Populates the category list and sets default values.
     */
    @FXML
    public void initialize() {
        categoryBox.getItems().addAll(
                "Food", "Transport", "Groceries",
                "Salary", "Entertainment", "Bills", "Other"
        );

        // Default to today's date
        datePicker.setValue(LocalDate.now());

        // Default to Expense
        expenseToggle.setSelected(true);
    }

    /**
     * Called when the user clicks "Save Transaction".
     * Validates input, stores the transaction, and returns to the list view.
     */
    @FXML
    private void handleSaveTransaction() {
        // --- Determine type ---
        String type = incomeToggle.isSelected() ? "Income" : "Expense";

        // --- Validate amount ---
        String amountText = amountField.getText().trim();
        if (amountText.isEmpty()) {
            showError("Please enter an amount.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            showError("Amount must be a valid number.");
            return;
        }

        if (amount <= 0) {
            showError("Amount must be greater than zero.");
            return;
        }

        // --- Validate category ---
        String category = categoryBox.getValue();
        if (category == null || category.isEmpty()) {
            showError("Please select a category.");
            return;
        }

        // --- Collect optional fields ---
        String    description = descriptionField.getText().trim();
        LocalDate date        = datePicker.getValue() != null
                                ? datePicker.getValue()
                                : LocalDate.now();

        // --- Save the transaction ---
        Transaction transaction = new Transaction(type, amount, category, description, date);
        TransactionSession.add(transaction);

        // --- Navigate back to transaction list ---
        try {
            SceneManager.switchTo("transaction-controller.fxml");
        } catch (IOException e) {
            showError("Transaction saved, but could not return to the list.");
        }
    }

    /**
     * Cancels the operation and navigates back without saving.
     */
    @FXML
    private void handleCancel() {
        try {
            SceneManager.switchTo("transaction-controller.fxml");
        } catch (IOException e) {
            showError("Could not navigate back.");
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
