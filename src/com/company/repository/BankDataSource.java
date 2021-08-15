package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.util.List;

public interface BankDataSource {
    List<Account> getAllAccounts();
    List<Customer> getAllCustomers();
    List<Employee> getAllEmployees();
    List<Transaction> getAllTransactions();

}
