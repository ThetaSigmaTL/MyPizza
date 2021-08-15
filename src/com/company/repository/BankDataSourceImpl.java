package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankDataSourceImpl implements BankDataSource{

    private final List<Account> accounts = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();


    public List<Account> getAllAccounts()
    {
        return accounts.;
    };

    public List<Customer> getAllCustomers()
    {
        return customers;
    };

    public List<Employee> getAllEmployees()
    {
        return employees;
    }

    @Override
    public List<Transaction> getAllTransactions() { return transactions; }


}
