package com.example.stocktradingplatform;

import java.util.ArrayList;

public class Market {

    private ArrayList<Stock> stocks;

    // Constructor
    public Market() {
        stocks = new ArrayList<>();

        // Add available stocks
        stocks.add(new Stock("AAPL", "Apple", 180));
        stocks.add(new Stock("TSLA", "Tesla", 250));
        stocks.add(new Stock("GOOG", "Google", 140));
        stocks.add(new Stock("MSFT", "Microsoft", 330));
        stocks.add(new Stock("AMZN", "Amazon", 150));
    }

    // Display all stocks
    public void displayMarket() {
        System.out.println("===== STOCK MARKET =====");

        for (Stock stock : stocks) {
            stock.displayStock();
            System.out.println("------------------------");
        }
    }

    // ==========================
    // NEW METHOD STARTS HERE
    // ==========================
    public Stock findStock(String symbol) {

        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }

        return null;
    }
    // ==========================
    // NEW METHOD ENDS HERE
    // ==========================

}