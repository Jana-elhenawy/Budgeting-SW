package com.example.SW.Util;

import com.example.SW.Model.Budget;
import java.util.ArrayList;
import java.util.List;

public class BudgetSession {

    private static final List<Budget> budgets = new ArrayList<>();

    public static void add(Budget budget) {
        budgets.add(budget);
    }

    public static List<Budget> getAll() {
        return budgets;
    }

    public static void update(int index, Budget budget) {
        budgets.set(index, budget);

    }

}