package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageImpl implements Storage{

    @Override
    public List<String> readAccountsFile() {

        List<String> accountsFIleString= new ArrayList<>();
        try (BufferedReader readFile = new BufferedReader(new FileReader(new File(PathStrings.accountsFIlePathString)))){
            String line;
            while((line = readFile.readLine()) != null){
                accountsFIleString.add(line);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return accountsFIleString;
    }

    @Override
    public List<String> readCustomersFile() {
        List<String> customerFIleString= new ArrayList<>();
     try (BufferedReader readfile = new BufferedReader(new FileReader(new File(PathStrings.customersFilePathString)))){
         String line;
         while ((line = readfile.readLine()) != null){
             customerFIleString.add(line);
         }
     }
     catch (IOException e) {
         e.printStackTrace();
     }
     return customerFIleString;
    }

    @Override
    public List<String> readTransactionsFile() {
        List<String> transactionFileString= new ArrayList<>();
        try (BufferedReader readfile = new BufferedReader(new FileReader(new File(PathStrings.transactionsFilePathString)))) {
            String line;
            while ((line = readfile.readLine()) != null){
                transactionFileString.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return transactionFileString;
    }

    @Override
    public List<String> readEmployeesFile() {
        List<String> employeeFIleString= new ArrayList<>();
        try (BufferedReader readfile = new BufferedReader(new FileReader(new File(PathStrings.employeesFilePathString)))){
            String line;
            while ((line = readfile.readLine()) != null){
                employeeFIleString.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return employeeFIleString;
    }
}
