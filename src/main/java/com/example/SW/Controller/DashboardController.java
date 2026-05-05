package com.example.SW.Controller;

import com.example.SW.Model.Transaction;
import com.example.SW.Util.SceneManager;
import com.example.SW.Util.TransactionSession;
import com.example.SW.Util.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class DashboardController {

    @FXML private Label welcomeLabel;
    @FXML private Label balanceLabel;
    @FXML private Label incomeLabel;
    @FXML private Label expenseLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome " + UserSession.getName());

        double income = 0;
        double expense = 0;

        for (Transaction t : TransactionSession.getAll()) {
            if (t.getType().equals("Income")) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
        }

        incomeLabel.setText("Income: " + income);
        expenseLabel.setText("Expense: " + expense);
        balanceLabel.setText("Balance: " + (income - expense));
    }

    @FXML
    private void goToTransactions() throws IOException {
        SceneManager.switchTo("transaction-controller.fxml");
    }

    @FXML
    private void goToBudget() throws IOException {
        SceneManager.switchTo("budget.fxml");
    }

    @FXML
    private void goToGoals() throws IOException {
        SceneManager.switchTo("goals-tracker.fxml");
    }

    @FXML
    private void goToReports() throws IOException {
        SceneManager.switchTo("view-reports.fxml");
    }

    @FXML
    private void goToProfile() throws IOException {
        SceneManager.switchTo("profile-controller.fxml");
    }
}