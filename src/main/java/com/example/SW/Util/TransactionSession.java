package com.example.SW.Util;

import com.example.SW.Model.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionSession {
    private static final List<Transaction> transactions = new ArrayList<>();

    static {
        // hardcoded samples
        transactions.add(new Transaction("Expense", 12.50, "Food", "McDonald's", LocalDate.now()));
        transactions.add(new Transaction("Income",  3200.0, "Salary", "Monthly salary", LocalDate.now().minusDays(1)));
        transactions.add(new Transaction("Expense", 8.00,  "Transport", "Uber", LocalDate.now().minusDays(1)));
        transactions.add(new Transaction("Expense", 45.20, "Groceries", "Carrefour", LocalDate.now().minusDays(2)));
    }

    public static List<Transaction> getAll() {
        return new ArrayList<>(transactions);
    }

    public static void add(Transaction t) {
        transactions.add(t);
    }

    public static List<Transaction> filterByCategory(String category) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getCategory().equalsIgnoreCase(category)) result.add(t);
        }
        return result;
    }

    public static List<Transaction> filterByType(String type) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase(type)) result.add(t);
        }
        return result;
    }

    public static List<Transaction> filterByDateRange(LocalDate from, LocalDate to) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (!t.getDate().isBefore(from) && !t.getDate().isAfter(to)) result.add(t);
        }
        return result;
    }
}