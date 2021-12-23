package com.company.menus;

import com.company.model.Account;
import com.company.model.AccountNumGenerator;
import com.company.model.enums.AccountStatus;
import com.company.repository.AccountDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountMenu {
    public void accountMenu(){
        int userChoice =0;
        boolean isMenuActive = true;
        while(isMenuActive){
            System.out.println("Options for account management:");
            System.out.println("1. Search by account number\n2. Search by account status\n3. Get all\n4. Search by id\n5. Insert\n.6. Delete\n7. Update");
            while(true){
                System.out.print("Select an option: ");
                Scanner input = new Scanner(System.in);
                try{
                    userChoice = input.nextInt();
                    break;
                }
                catch(Exception ex){
                    System.out.println("Please enter an integer number of option");
                }
            }
            switch (userChoice){
                case 1: {
                    System.out.println("Search by account number selected");
                    System.out.print("Enter 20-digit account number: ");
                    Scanner input = new Scanner(System.in);
                    String accountNum = input.nextLine();
                    AccountDAO accountDAO = new AccountDAO();
                    try {
                        Account account = accountDAO.findAccountByAccountNum(accountNum);
                        System.out.println(account.getAccountNum()+ " " + account.getBalance() + " " + account.getCustomerId() + " " + account.getStatus());
                    }
                    catch (Exception ex){
                        System.out.println("Enter 20-digit account number");
                    }

                }
                case 2: {
                    System.out.println("Search by account status selected");
                    System.out.println("Choose status number for search: 1. Active 2. Inactive 3. Blocked");
                    AccountDAO accountDAO = new AccountDAO();
                    List<Account> accountList = new ArrayList<>();
                    accountList = null;
                    Scanner input = new Scanner(System.in);
                    try {
                        AccountStatus status = null;
                        int userInput = input.nextInt();
                        if (userInput == 1)
                            status = AccountStatus.Active;
                        else if (userInput == 2)
                            status = AccountStatus.Inactive;
                        else if (userInput == 3)
                            status = AccountStatus.Blocked;
                        else
                            System.out.println("Wrong input");
                        if (status != null)
                           accountList = accountDAO.searchByAccountStatus(status);
                        else {
                            System.out.println("Wrong input");
                            break;
                        }
                        for (Account account: accountList){
                            System.out.println(account.getAccountNum() + " " + account.getCustomerId() + " " + account.getBalance()
                                    + " " + account.getStatus());
                        }
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                case 3:{
                    System.out.println("Get all selected");
                    try{
                        AccountDAO accountDAO =new AccountDAO();
                       List <Account> accounts =  accountDAO.getAll();
                        for(Account account: accounts){
                            System.out.println(account.getAccountNum() + " " + account.getCustomerId() + " " + account.getBalance()
                                    + " " + account.getStatus());
                        }
                    }
                    catch (Exception exception){

                    }
                }
                case 4:{
                    System.out.println("Search by id selected");
                    System.out.println("Please enter customer id");
                    Scanner scanner = new Scanner(System.in);
                    AccountDAO accountDAO = new AccountDAO();
                    List<Account> accounts = null;
                    try{
                        String customerId = scanner.nextLine();
                        if(customerId != null)
                           accounts = accountDAO.findById(customerId);
                        else{
                            System.out.println("I don't know what but something goes wrong");
                        }
                        if (accounts != null){
                            for(Account account: accounts){
                                System.out.println(account.getAccountNum() + " " + account.getCustomerId() + " " + account.getBalance()
                                        + " " + account.getStatus());
                            }
                        }
                        else{
                            System.out.println("No such customer found");
                        }
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
                case 5:{
                    System.out.println("Insert selected");
                    System.out.println("Enter customer id");
                    AccountDAO accountDAO = new AccountDAO();
                    Scanner input = new Scanner(System.in);
                    String id = input.nextLine();
                    if (id == null | id.length() != 20) {
                        System.out.println("Wrong input");
                        break;
                    }
                    try {
                        Account account = new Account(AccountNumGenerator.accountNum(), new BigDecimal("0"),AccountStatus.Active, id);
                        accountDAO.insert(account);
                        System.out.println("Account inserted");
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
                case 6: {
                    System.out.println("Delete account selected");
                    System.out.print("Enter account number to delete: ");
                    Scanner input = new Scanner(System.in);
                    String accountNum = input.nextLine();
                    if (accountNum == null || accountNum.length() != 20) {
                        System.out.println("Wrong id input");
                        break;
                    }
                    try {
                        AccountDAO accountDAO = new AccountDAO();
                        Account account = accountDAO.findAccountByAccountNum(accountNum);
                        if (account != null){
                            boolean deleted = accountDAO.delete(account);
                            if(deleted)
                                System.out.println("Deleted");
                            else
                                System.out.println("Oops");
                        }
                    }
                    catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
                case 7:{
                    System.out.println("Update selected");
                    System.out.print("Enter account number to delete");
                    Scanner input = new Scanner(System.in);
                    String num = input.nextLine();
                    if (num == null || num.length() != 20) {
                        System.out.println("Wrong input");
                        break;
                    }
                    try {
                        AccountDAO accountDAO = new AccountDAO();
                        Account account =  accountDAO.findAccountByAccountNum(num);
                        System.out.print("1. Add 2. Withdraw 3. Change status");
                        int choise = input.nextInt();
                        if (choise == 1){
                            System.out.print("System enter sum to add: ");
                            account.addBalance(input.nextBigDecimal());
                        }
                        if (choise == 2){
                            System.out.println("Enter sum to withdraw");
                            account.subBalance(input.nextBigDecimal());
                        }
                        if (choise == 3){
                            System.out.println("1. Active 2. Inactive 3. Blocked");
                            int statusChoise = input.nextInt();
                            if (statusChoise == 1)
                                account.setStatus(AccountStatus.Active);
                            else if (statusChoise == 2)
                                account.setStatus(AccountStatus.Inactive);
                            else if (statusChoise == 3)
                                account.setStatus(AccountStatus.Blocked);
                            else {
                                System.out.println("Wrong input");
                                break;
                            }
                        }

                    }
                    catch (Exception ex){

                    }
                }
            }
        }
    }
}
