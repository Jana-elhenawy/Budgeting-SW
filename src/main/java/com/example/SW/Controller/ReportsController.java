package com.example.SW.Controller;

import com.example.SW.Model.Report;
import com.example.SW.Util.ReportsSession;
import com.example.SW.Util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class ReportsController {

    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Button generateButton;
    @FXML private PieChart expensePieChart;
    @FXML private BarChart incomeExpenseBarChart;
    @FXML private Label insightMessage;

    ReportsSession reportsSession = new ReportsSession();

    public void generateReport(){

        if(startDate.getValue() == null || endDate.getValue() == null){
            insightMessage.setText("Please select a date range first!");
            return;
        }
        LocalDate start = startDate.getValue();
        LocalDate end = endDate.getValue();
        Report report = reportsSession.generateReport(start, end);
        expensePieChart.getData().clear();
        for(Map.Entry<String, Double> entry : report.getCategoryTotals().entrySet()){
            expensePieChart.getData().add(
                    new PieChart.Data(entry.getKey(), entry.getValue())
            );
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Income vs Expense");
        series.getData().add(new XYChart.Data<>("Income", report.getTotalIncome()));
        series.getData().add(new XYChart.Data<>("Expense", report.getTotalExpense()));
        incomeExpenseBarChart.getData().clear();
        incomeExpenseBarChart.getData().add(series);

        insightMessage.setText("Total Income: " + report.getTotalIncome() +
                " | Total Expense: " + report.getTotalExpense());
    }
    @FXML
    private void handleBackToDashboard() throws IOException {
        SceneManager.switchTo("dashboard.fxml");
    }
}