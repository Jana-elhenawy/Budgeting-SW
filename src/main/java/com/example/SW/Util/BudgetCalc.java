package com.example.SW.Util;

import com.example.SW.Model.Transaction;

public class BudgetCalc {

    public static double getSpentForCategory(String category) {
        double total = 0;

        for (Transaction t : TransactionSession.getAll()) {
            if (t.getCategory().equals(category) && t.getType().equals("Expense")) {
                total += t.getAmount();
            }
        }

        return total;
    }
}