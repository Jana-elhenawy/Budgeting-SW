package com.example.SW.Model;

import java.time.LocalDate;
import java.util.Map;

public class Report {

    private LocalDate startDate;
    private LocalDate endDate;
    private Map<String, Double> categoryTotals;
    private double totalIncome;
    private double totalExpense;

    public Report(LocalDate startDate, LocalDate endDate, Map<String, Double> categoryTotals, double totalIncome, double totalExpense){
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryTotals = categoryTotals;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
    }

    public LocalDate getStartDate(){return startDate;}
    public LocalDate getEndDate(){return endDate;}
    public Map<String, Double> getCategoryTotals(){return categoryTotals;}
    public double getTotalIncome(){return totalIncome;}
    public double getTotalExpense(){return totalExpense;}

    public void setStartDate(LocalDate startDate){this.startDate = startDate;}
    public void setEndDate(LocalDate endDate){this.endDate = endDate;}
    public void setCategoryTotals(Map<String, Double> categoryTotals){this.categoryTotals = categoryTotals;}
    public void setTotalIncome(double totalIncome){this.totalIncome = totalIncome;}
    public void setTotalExpense(double totalExpense){this.totalExpense = totalExpense;}

}
