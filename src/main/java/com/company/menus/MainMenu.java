package com.company.menus;

import com.company.model.Account;

import java.util.Scanner;

public class MainMenu {
    public void Menu() {
        boolean isMenuActive = true;
        int userChoise;
        while (isMenuActive) {
            System.out.println(" ");
            System.out.println("Options");
            System.out.println("1. Customers\n2. Accounts\n3. Transactions\n4. Exit");
            while(true){
                System.out.println("Select an option...");
                Scanner input = new Scanner(System.in);
                try {
                    userChoise = input.nextInt();
                    if(userChoise > 5 | userChoise < 1){
                        System.out.println("Enter a number of option!");
                    }
                    break;
                }
                catch (Exception e){
                    System.out.println("Please enter an integer!\n");
                }
            }
            switch (userChoise){
                case 1:{
                    CustomerMenu customerMenu = new CustomerMenu();
                    customerMenu.startMenu();
                }
                case 2:{
                    AccountMenu accountMenu = new AccountMenu();
                    accountMenu.accountMenu();
                }
                case 3:{
                    TransactionMenu transactionMenu = new TransactionMenu();
                    transactionMenu.startMenu();
                }
                case 4: {
                    isMenuActive  = false;
                }

            }
        }

    }


}
