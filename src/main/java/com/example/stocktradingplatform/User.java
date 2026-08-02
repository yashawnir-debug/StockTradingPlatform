package com.example.stocktradingplatform;
import java.util.ArrayList;

public class User {

    private String name;
    private double balance;
    private Portfolio portfolio;
    private ArrayList<Transaction> transactions;

    // Constructor
    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new Portfolio();
        transactions = new ArrayList<>();
    }
    // Sell Stock
    public void sellStock(Stock stock, int quantity) {

        boolean removed = portfolio.removeStock(stock.getSymbol(), quantity);

        if (removed) {

            double amount = stock.getPrice() * quantity;

            balance = balance + amount;

            transactions.add(new Transaction(
                    "SELL",
                    stock.getSymbol(),
                    quantity,
                    stock.getPrice()
            ));

            System.out.println("Stock sold successfully!");
            System.out.println("Updated Balance : ₹" + balance);

        } else {

            System.out.println("Not enough shares to sell.");

        }
    }

    // Display user details
    public void displayUser() {
        System.out.println("Name : " + name);
        System.out.println("Balance : ₹" + balance);
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Get portfolio
    public Portfolio getPortfolio() {
        return portfolio;
    }
    // BUY STOCK METHOD
    public void buyStock(Stock stock, int quantity) {

        double totalCost = stock.getPrice() * quantity;

        if (balance >= totalCost) {

            balance = balance - totalCost;

            portfolio.addStock(stock.getSymbol(), quantity);

            transactions.add(new Transaction(
                    "BUY",
                    stock.getSymbol(),
                    quantity,
                    stock.getPrice()
            ));

            System.out.println("Stock purchased successfully!");
            System.out.println("Remaining Balance : ₹" + balance);

        } else {

            System.out.println("Insufficient Balance!");

        }
    }


    // Display Transactions
    public void displayTransactions() {

        System.out.println("===== TRANSACTION HISTORY =====");

        if (transactions.isEmpty()) {

            System.out.println("No transactions found.");

        } else {

            for (Transaction transaction : transactions) {

                transaction.displayTransaction();

            }

        }
    }

}

