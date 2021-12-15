package com.company.menus;

import com.company.model.Customer;
import com.company.model.Transaction;
import com.company.model.enums.TransactionType;
import com.company.repository.TransactionDAO;

import java.util.List;
import java.util.Scanner;

public class TransactionMenu {
    public void startMenu(){
        int userChoise = 0;
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println(" ");
            System.out.println("Options for transaction management:");
            System.out.println("1.Get all transactions\n2. Find by ID\n3.Insert\n4.Update\n5.Delete\n6.Cancel");
            while (true) {
                System.out.print("Select an option: ");
                Scanner input = new Scanner(System.in);
                try {
                    userChoise = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter an integer number!");
                }
            }
        }
        switch (userChoise) {
            case 1: {
                System.out.println("Get all transactions selected");
                List<Transaction> transactionList;
                TransactionDAO transactionRep = new TransactionDAO();
                try {
                    transactionList = transactionRep.getAll();
                    for (Transaction transaction : transactionList) {
                        System.out.println(transaction.getTransactionID() + "|" + transaction.getTransactionType() + "|" + transaction.getPayeeAccountNum() + "|"
                                + transaction.getSenderAccountNum() + "|" + transaction.getSum() + "|" + transaction.getTimestamp());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
            case 2: {
                System.out.println("Find by ID selected");
                System.out.print("Enter 36 character transaction ID: ");
                Scanner inputId = new Scanner(System.in);
                TransactionDAO transactionRep = new TransactionDAO();
                try {
                    Transaction transaction = transactionRep.findById(inputId.nextLine());
                    System.out.println(" ");
                    System.out.println(transaction.getTransactionID() + " " + transaction.getTransactionType() + " " + transaction.getPayeeAccountNum() + " "
                            + transaction.getSenderAccountNum() + " "   + transaction.getSum() + " " + transaction.getTimestamp());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Please enter correct transaction ID!");
                }
                break;
            }
            case 3: {
                System.out.println("Insert transaction selected");
                Scanner input = new Scanner(System.in);
                TransactionDAO transactionDAO = new TransactionDAO();
                try {
                    System.out.print("Choose transaction type (transfer or ATM): ");
                    String transactionTypeString = input.nextLine();
                    if (transactionTypeString.equals(TransactionType.ATM) ^ transactionTypeString.equals(TransactionType.Transfer));
                }
                catch (Exception exception){

                }
            }
        }
    }

}
