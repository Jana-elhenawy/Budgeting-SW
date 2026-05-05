package com.example.SW.Controller;

import com.example.SW.Model.Budget;
import com.example.SW.Util.BudgetSession;
import com.example.SW.Util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddBudgetController {

    @FXML private TextField categoryField;
    @FXML private TextField limitField;

    @FXML
    private void handleSave() throws IOException {
        String category = categoryField.getText();
        double limit = Double.parseDouble(limitField.getText());

        Budget budget = new Budget(category, limit);
        BudgetSession.add(budget);

        SceneManager.switchTo("budget.fxml");
    }

    @FXML
    private void handleBack() throws IOException {
        SceneManager.switchTo("budget.fxml");
    }
}