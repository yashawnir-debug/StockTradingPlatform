package com.example.stocktradingplatform;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Market
        Market market = new Market();

        // Create User
        User user = new User("Yashaswini", 10000);

        int choice;

        do {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. Display Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. View Transactions");
            System.out.println("7.Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();


            // Option 1: Display Market
            if (choice == 1) {

                market.displayMarket();

            }


            // Option 2: Buy Stock
            if (choice == 2) {

                System.out.print("Enter Stock Symbol: ");
                String symbol = sc.next();

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();


                Stock stock = market.findStock(symbol);


                if (stock != null) {

                    user.buyStock(stock, quantity);

                } else {

                    System.out.println("Stock not found!");

                }

            }


            // Option 3: Sell Stock
            if (choice == 3) {

                System.out.print("Enter Stock Symbol: ");
                String sellSymbol = sc.next();

                System.out.print("Enter Quantity: ");
                int sellQuantity = sc.nextInt();


                Stock sellStock = market.findStock(sellSymbol);


                if (sellStock != null) {

                    user.sellStock(sellStock, sellQuantity);

                } else {

                    System.out.println("Stock not found!");

                }

            }


            // Option 4: View Portfolio
            if (choice == 4) {

                user.getPortfolio().displayPortfolio();

            }


            // Option 5: View Balance
            if (choice == 5) {
                user.displayTransactions();

                System.out.println("Current Balance : ₹" + user.getBalance());

            }


            // Option 6: Exit
            if (choice == 6) {

                System.out.println("Thank you for using Stock Trading Platform!");

            }


        } while (choice != 7);


        sc.close();

    }

}