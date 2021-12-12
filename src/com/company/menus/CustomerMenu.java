package com.company.menus;
import com.company.model.Customer;
import com.company.model.IdGenerator;
import com.company.repository.CustomerRepImpl;
import java.io.*;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    public static final String redColor= "\\u001B[31m";
    public static final String resetColor = "\\u001B[0m";
    public void startMenu() {
        int userChoise = 0;
        boolean isMenuActive = true;
        while (isMenuActive)  {
            System.out.println(" ");
            System.out.println("Options for customers management:");
            System.out.println("1. Find by passport number\n2. Find by ID\n3. Find by name\n4.Get all\n5.Insert\n6.Update\n7.Delete\n8.Cancel");
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
                case 1:{
                    System.out.println("Find by passport number selected");
                    System.out.print("Enter the number: ");
                    Scanner inputPassNum = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    try {
                        String passNum = inputPassNum.nextLine();
                        if (!passNum.matches("//d{10}")) {
                            System.out.println(redColor + "Incorrect input!" + resetColor);
                            break;
                        }
                        Customer customer = customerRep.findByPassNum(passNum);
                        if (customer == null){
                            System.out.println("No such customer!");
                            break;
                        }
                        System.out.println(" ");
                        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPassNum() + " " + customer.getId());
                    } catch (Exception exception ) {
                            System.out.println("Please enter 10-digit passport number!");
                            break;
                    }
                    break;
                }
                case 2:{
                    System.out.println("Find by ID selected");
                    System.out.print("Enter customer ID: ");
                    Scanner inputId = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    try {
                        Customer customer = customerRep.findById(inputId.nextLine());
                        System.out.println(" ");
                        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPassNum() + " " + customer.getId());

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Please enter correct cuctomer ID!");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Find by name selected");
                    Scanner inputName = new Scanner(System.in);
                    List<Customer> customerList = new ArrayList<>();
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    try {
                        System.out.print("Enter firstname: ");
                        String name = inputName.nextLine();
                        System.out.println(" ");
                        System.out.print("Enter lastname: ");
                        String lastname = inputName.nextLine();
                        customerList = customerRep.findByName(name, lastname);
                        for (Customer customer : customerList) {
                            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getId() + " " + customer.getPassNum());
                        }
                    } catch (Exception e) {
                        System.out.println("Enter firstname and lastname of customer!");
                    }
                    break;
                }
                case 4:{
                    System.out.println("Get all customers selected");
                    List<Customer> customerList;
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    try {
                        customerList = customerRep.getAll();
                        for (Customer customer : customerList) {
                            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getId() + " " + customer.getPassNum());

                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 5:{
                    Scanner input = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    System.out.println("Insert customer selected");
                    try {
                        System.out.print("Enter name: ");
                        String name = input.nextLine();
                        System.out.print("Enter Lastname: ");
                        String lastname = input.nextLine();
                        System.out.print("Enter passport number: ");
                        String passNum = input.nextLine();
                        Customer customer = new Customer(name, lastname, IdGenerator.generateID(), passNum);

                        customerRep.insert(customer);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 6:{
                    Scanner input = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    System.out.println("Update customer personal information selected");
                    try {
                        System.out.print("Enter customer ID to update personal information: ");
                        String id = input.nextLine();
                        Customer customer = customerRep.findById(id);
                        customerRep.update(customer);
                    } catch (Exception e) {
                        System.out.println("Enter customer ID to update personal information!");
                    }
                    break;
                }
                case 7:{
                    Scanner input = new Scanner(System.in);
                    CustomerRepImpl customerRep = new CustomerRepImpl();
                    System.out.println("Delete customer selected");
                    try {
                        System.out.print("Enter customer id to delete: ");
                        String id = input.nextLine();
                        Customer customer = customerRep.findById(id);
                        customerRep.delete(customer);
                    }
                    catch (Exception e){
                        System.out.println("Enter valid customer id!");
                    }
                    break;
                }
                case 8:
                    isMenuActive = false;
                    break;
            }
        }
    }
}



