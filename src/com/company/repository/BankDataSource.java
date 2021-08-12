package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;

import java.util.List;

public interface BankDataSource {
    List<Account> getAccounts();
    List<Customer> getCustomers();
    List<Employee> getEmployees();

}
