package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class BankDataSourceImpl implements BankDataSource{
    private final List<Account> accounts = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();

    public void setAccounts(List<Account> accounts)
    {
        for (Account a:accounts) {
            this.accounts.add(a);

        }
    }
    public void setCustomers(Customer customer)
    {
        this.customers.add(customer);
    }
    public void setEmployees(List<Employee> employees)
    {
        for (Employee a:employees) {
            this.employees.add(a);

        }
    }

    public List<Account> getAccounts()
    {
        return accounts;
    };

    public List<Customer> getCustomers()
    {
        return customers;
    };
    public List<Employee> getEmployees()
    {
        return employees;
    };
}
