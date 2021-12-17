package com.company.menus;

import com.company.model.Customer;
import com.company.model.IdGenerator;
import com.company.model.Transaction;
import com.company.model.enums.TransactionType;
import com.company.repository.TransactionDAO;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class TransactionMenu {
    public void startMenu() {
        int userChoise = 0;
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println(" ");
            System.out.println("Options for transaction management:");
            System.out.println("1.Get all transactions\n2. Find by ID\n3. Insert\n4. Delete\n5. Cancel");
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
                                + transaction.getSenderAccountNum() + " " + transaction.getSum() + " " + transaction.getTimestamp());
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
                        System.out.print("Choose transaction type:\n1. Transfer\n2. ATM ");
                        String transactionTypeString = input.nextLine();
                        TransactionType transactionType;
                        if (transactionTypeString.equals("1")) {
                            transactionType = TransactionType.Transfer;
                        } else if (transactionTypeString.equals("2")) {
                            transactionType = TransactionType.ATM;
                        } else {
                            System.out.println("Please select transaction type!");
                            break;
                        }
                        System.out.print("Enter 20-digit payee account number: ");
                        String payeeAccountNumber = input.nextLine();
                        System.out.println(" ");
                        System.out.print("Enter 20-digit sender account number: ");
                        String senderAccountNumber = input.nextLine();
                        System.out.print("");
                        System.out.print("Enter sum:");
                        BigDecimal sum = new BigDecimal(input.nextLine());
                        Transaction transaction = new Transaction(IdGenerator.generateID(), payeeAccountNumber, senderAccountNumber, sum,
                                transactionType, new Timestamp(System.currentTimeMillis()));
                        transactionDAO.insert(transaction);
                        System.out.println("Transaction inserted");
                        break;
                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
                    break;
                }

                case 4: {
                    System.out.println("Deleting selected ");
                    Scanner input = new Scanner(System.in);
                    TransactionDAO transactionDAO = new TransactionDAO();
                    try {
                        System.out.println("Enter transaction id: ");
                        String id = input.nextLine();
                        Transaction transaction = transactionDAO.findById(id);
                        transactionDAO.delete(transaction);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5: {
                    isMenuActive = false;
                    break;
                }
            }
        }
    }
}
