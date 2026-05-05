package com.example.SW.Controller;

import com.example.SW.Model.Transaction;
import com.example.SW.Util.SceneManager;
import com.example.SW.Util.TransactionSession;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class TransactionController {

    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String>    colType;
    @FXML private TableColumn<Transaction, Double>    colAmount;
    @FXML private TableColumn<Transaction, String>    colCategory;
    @FXML private TableColumn<Transaction, String>    colDescription;
    @FXML private TableColumn<Transaction, LocalDate> colDate;

    @FXML private ComboBox<String>  filterTypeBox;
    @FXML private ComboBox<String>  filterCategoryBox;
    @FXML private DatePicker        fromDatePicker;
    @FXML private DatePicker        toDatePicker;
    @FXML private Label             noDataLabel;
    @FXML private Label             totalIncomeLabel;
    @FXML private Label             totalExpenseLabel;

    @FXML
    public void initialize() {
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        filterTypeBox.getItems().addAll("All", "Income", "Expense");
        filterTypeBox.setValue("All");

        filterCategoryBox.getItems().addAll(
                "All", "Food", "Transport", "Groceries",
                "Salary", "Entertainment", "Bills", "Other"
        );
        filterCategoryBox.setValue("All");

        loadAll();
    }

    private void loadAll() {
        displayTransactions(TransactionSession.getAll());
    }

    @FXML
    private void handleFilter() {
        List<Transaction> list = TransactionSession.getAll();

        String type = filterTypeBox.getValue();
        if (type != null && !type.equals("All")) {
            list = list.stream().filter(t -> t.getType().equals(type)).toList();
        }

        String category = filterCategoryBox.getValue();
        if (category != null && !category.equals("All")) {
            list = list.stream().filter(t -> t.getCategory().equalsIgnoreCase(category)).toList();
        }

        LocalDate from = fromDatePicker.getValue();
        LocalDate to   = toDatePicker.getValue();
        if (from != null && to != null) {
            list = list.stream()
                    .filter(t -> !t.getDate().isBefore(from) && !t.getDate().isAfter(to))
                    .toList();
        }

        displayTransactions(list);
    }

    @FXML
    private void handleClearFilter() {
        filterTypeBox.setValue("All");
        filterCategoryBox.setValue("All");
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        loadAll();
    }

    @FXML
    private void handleAddTransaction() {
        try {
            SceneManager.switchTo("add-transaction-view.fxml");
        } catch (IOException e) {
            noDataLabel.setText("Could not open Add Transaction screen.");
            noDataLabel.setVisible(true);
        }
    }

    private void displayTransactions(List<Transaction> list) {
        if (list.isEmpty()) {
            noDataLabel.setVisible(true);
            transactionTable.setVisible(false);
        } else {
            noDataLabel.setVisible(false);
            transactionTable.setVisible(true);
            transactionTable.setItems(FXCollections.observableArrayList(list));
        }

        double totalIncome  = list.stream().filter(t -> t.getType().equals("Income")).mapToDouble(Transaction::getAmount).sum();
        double totalExpense = list.stream().filter(t -> t.getType().equals("Expense")).mapToDouble(Transaction::getAmount).sum();
        totalIncomeLabel.setText(String.format("+%.2f %s", totalIncome, "EGP"));
        totalExpenseLabel.setText(String.format("-%.2f %s", totalExpense, "EGP"));
    }
    @FXML
    private void handleBackToDashboard() throws IOException {
        SceneManager.switchTo("dashboard.fxml");
    }
}
