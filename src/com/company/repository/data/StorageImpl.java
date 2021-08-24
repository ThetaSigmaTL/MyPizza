package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageImpl implements Storage{

    @Override
    public List<Account> readAccountsFile() {
       List <Account> loadedAccounts = new ArrayList<>();
        File accountFile = new File(PathStrings.accountsFIlePathString);
        if (accountFile.exists()) {
            Scanner readAccountFile = new Scanner(PathStrings.accountsFIlePathString);
            while (readAccountFile.hasNext()) {

            }


        }
        return null;
    }

    @Override
    public List<Customer> readCustomersFile() {
        return null;
    }

    @Override
    public List<Transaction> readTransactionsFile() {
        return null;
    }

    @Override
    public List<Employee> readEmployeesFile() {
        return null;
    }
}
