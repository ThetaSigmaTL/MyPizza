package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Transaction;

import java.util.List;

public class DataSourceImpl implements DataSource {
    private final Storage storage;
    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    public DataSourceImpl(Storage storage) {
        this.storage = storage;
    }
}
