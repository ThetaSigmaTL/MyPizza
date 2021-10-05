package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.util.List;

public interface Storage {
    public List<String> readAccountsFile();

    public List<String> readCustomersFile();

    public List<String> readTransactionsFile();

    public List<String> readEmployeesFile();
}
