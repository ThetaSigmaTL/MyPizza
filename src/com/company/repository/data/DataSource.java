package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface DataSource {

    List<Account> getAccounts ();

    List<Customer> getCustomers();

    List<Transaction> getTransactions();
}
