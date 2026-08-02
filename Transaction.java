package com.example.stocktradingplatform;

public class Transaction {

    private String type;
    private String symbol;
    private int quantity;
    private double price;


    public Transaction(String type, String symbol, int quantity, double price) {

        this.type = type;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;

    }


    public void displayTransaction() {

        System.out.println(
                type + " | " +
                        symbol + " | " +
                        quantity + " shares | ₹" +
                        price
        );

    }

}