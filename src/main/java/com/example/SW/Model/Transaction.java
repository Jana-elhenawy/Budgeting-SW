package com.example.SW.Model;

import java.time.LocalDate;

/**
 * Represents a single financial transaction (income or expense).
 */
public class Transaction {

    private String type;        // "Income" or "Expense"
    private double amount;
    private String category;
    private String description;
    private LocalDate date;

    /**
     * Constructs a Transaction.
     *
     * @param type        "Income" or "Expense"
     * @param amount      positive monetary amount
     * @param category    spending/income category
     * @param description optional user note
     * @param date        date of the transaction
     */
    public Transaction(String type, double amount, String category,
                       String description, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
