package com.example.SW.Util;

import com.example.SW.Model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory store for the current user's transactions.
 * Acts as the transaction "database" for this phase.
 */
public class TransactionSession {

    private static final List<Transaction> transactions = new ArrayList<>();

    private TransactionSession() { }

    /**
     * Adds a new transaction to the store.
     *
     * @param transaction the transaction to add
     */
    public static void add(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Returns a mutable copy of all stored transactions.
     *
     * @return list of all transactions
     */
    public static List<Transaction> getAll() {
        return new ArrayList<>(transactions);
    }

    /** Clears all transactions (used on logout). */
    public static void clear() {
        transactions.clear();
    }
}
