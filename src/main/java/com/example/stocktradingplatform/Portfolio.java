package com.example.stocktradingplatform;

import java.util.HashMap;

public class Portfolio {

    private HashMap<String, Integer> stocks;

    // Constructor
    public Portfolio() {
        stocks = new HashMap<>();
    }

    // Add stock
    public void addStock(String symbol, int quantity) {
        if (stocks.containsKey(symbol)) {
            stocks.put(symbol, stocks.get(symbol) + quantity);
        } else {
            stocks.put(symbol, quantity);
        }
    }
    public boolean removeStock(String symbol, int quantity) {

        if (stocks.containsKey(symbol)) {

            int currentQuantity = stocks.get(symbol);

            if (currentQuantity >= quantity) {

                currentQuantity = currentQuantity - quantity;

                if (currentQuantity == 0) {
                    stocks.remove(symbol);
                } else {
                    stocks.put(symbol, currentQuantity);
                }

                return true;
            }
        }

        return false;
    }

    // Display portfolio
    public void displayPortfolio() {
        System.out.println("===== MY PORTFOLIO =====");

        if (stocks.isEmpty()) {
            System.out.println("Portfolio is empty.");
        } else {
            for (String symbol : stocks.keySet()) {
                System.out.println(symbol + " : " + stocks.get(symbol) + " shares");
            }
        }
    }
}