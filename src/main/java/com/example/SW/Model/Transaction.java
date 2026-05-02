package com.example.SW.Model;

import java.time.LocalDate;

public class Transaction {
    private String type;       // Income or Expense
    private double amount;
    private String category;
    private String description;
    private LocalDate date;

    public Transaction(String type, double amount, String category,
                       String description, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public String getCategory(){
        return category;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate(){
        return date;
    }

    public void setType(String type){
        this.type = type;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
}