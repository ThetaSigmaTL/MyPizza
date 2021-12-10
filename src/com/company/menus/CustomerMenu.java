package com.company.menus;
import com.company.model.Customer;
import com.company.repository.CustomerRepImpl;
import java.util.Scanner;

public class CustomerMenu {
    public CustomerMenu() {
        int userChoise = 0;
        int leave = 0;
        do  {
            System.out.println("Options for customers management:");
            System.out.println("1. Find by passport number\n2. Find by ID\n3. Find by name\n4.Get all\n5.Insert\n6.Update\n7.Delete\n8.Cancel");
            while (true) {
                System.out.println("Select an option...\n");
                Scanner input = new Scanner(System.in);
                try {
                    userChoise = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter an integer number!");
                }
            }
            switch (userChoise){
                case 1:
                {
                    System.out.println("Find by passport number selected");
                    System.out.println("Enter number...");
                    Scanner inputPassNum = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    try {
                        Customer customer = customerRep.findByPassNum(inputPassNum.toString());
                        System.out.println(" ");
                        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPassNum() + " " + customer.getId());
                    }
                    catch (Exception e){
                        System.out.println("Please enter 10-digit passport number");
                        break;
                    }
                }
                case 2: {
                    System.out.println("Find by ID selected");
                    System.out.println("Enter customer ID");
                    Scanner inputId = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    try {
                        Customer customer = customerRep.findById(inputId.toString());
                        System.out.println(" ");
                        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPassNum() + " " + customer.getId());
                        break;
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                        System.out.println("Please enter correct cuctomer ID");
                        break;
                    }
                }
                case 3:{
                    System.out.println("Find by name selected");
                    Scanner inputName = new Scanner(System.in);
                    System.out.println("Enter first name");


                }
            }

        }
        while (leave != 8);
    }
}
