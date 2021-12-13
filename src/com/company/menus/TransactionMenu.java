package com.company.menus;

import com.company.model.Customer;
import com.company.model.Transaction;
import com.company.repository.CustomerRepImpl;
import com.company.repository.TransactionRepImpl;

import java.util.List;
import java.util.Scanner;

public class TransactionMenu {
    public void startMenu(){
        int userChoise = 0;
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println(" ");
            System.out.println("Options for transaction management:");
            System.out.println("1.Get all transactions\n2. Find by ID\n3. Find by name\n4.Get all\n5.Insert\n6.Update\n7.Delete\n8.Cancel");
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
        switch (userChoise){
            case 1:{
                System.out.println("Get all transactions selected");
                List<Transaction> transactionList;
                TransactionRepImpl transactionRep = new TransactionRepImpl();
                try {
                    transactionList = transactionRep.getAll();
                    for (Transaction transaction : transactionList) {
                        System.out.println(transaction.getTransactionID() + "|" + transaction.getTransactionType() + "|" + transaction.getPayeeAccountNum()+ "|"
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
                CustomerRepImpl customerRep = new CustomerRepImpl();
                try {
                    Customer customer = customerRep.findById(inputId.nextLine());
                    System.out.println(" ");
                    System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPassNum() + " " + customer.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Please enter correct customer ID!");
                }
                break;
            }
        }
    }

}
