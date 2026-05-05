package com.example.SW.Controller;

import com.example.SW.Model.Budget;
import com.example.SW.Util.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class BudgetController {

    @FXML private TableView<Budget> budgetTable;
    @FXML private TableColumn<Budget, String> categoryCol;
    @FXML private TableColumn<Budget, Double> limitCol;
    @FXML private TableColumn<Budget, Double> spentCol;

    @FXML
    public void initialize() {
        categoryCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCategory()));

        limitCol.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().getLimit()).asObject());

        spentCol.setCellValueFactory(data -> {
            double spent = BudgetCalc.getSpentForCategory(data.getValue().getCategory());
            return new SimpleDoubleProperty(spent).asObject();
        });

        budgetTable.getItems().setAll(BudgetSession.getAll());
    }

    @FXML
    private void handleAddBudget() throws IOException {
        SceneManager.switchTo("add-budget.fxml");
    }

    @FXML
    private void handleBack() throws IOException {
        SceneManager.switchTo("dashboard.fxml");
    }
}