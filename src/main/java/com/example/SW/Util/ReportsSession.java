package com.example.SW.Util;

import com.example.SW.Model.Report;
import com.example.SW.Model.Transaction;
import com.example.SW.Util.TransactionSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportsSession {

    public Report generateReport(LocalDate startDate, LocalDate endDate){
        List<Transaction> transactions = TransactionSession.filterByDateRange(startDate, endDate);

        double totalIncome = 0;
        double totalExpense = 0;
        Map<String, Double> categoryTotals = new HashMap<>();
        for(Transaction t : transactions){
            if(t.getType().equals("Income")){
                totalIncome += t.getAmount();
            } else {
                totalExpense += t.getAmount();
                categoryTotals.put(t.getCategory(),
                        categoryTotals.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
            }
        }
        return new Report(startDate, endDate, categoryTotals, totalIncome, totalExpense);    }
}
