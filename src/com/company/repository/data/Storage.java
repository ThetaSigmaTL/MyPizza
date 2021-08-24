package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.util.List;

public interface Storage {
    public List<Account> readAccountsFile();

    public List<Customer> readCustomersFile();

    public List<Transaction> readTransactionsFile();

    public List<Employee> readEmployeesFile();
}
