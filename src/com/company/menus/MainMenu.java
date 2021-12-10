package com.company.menus;

import java.util.Scanner;

public class MainMenu {
    public void Menu() {
        int userChoise;
        while (true) {
            System.out.println(" ");
            System.out.println("Options");
            System.out.println("1. Customers\n2.Accounts\n3.Transactions\n4.Employees\n5.Exit");
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
                }

            }
        }

    }


}
