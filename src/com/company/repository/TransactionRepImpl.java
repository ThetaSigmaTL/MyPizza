package com.company.repository;

import com.company.model.Employee;
import com.company.model.Transaction;
import com.company.sqlite.GenericComs;

import java.util.List;

public class TransactionRepImpl implements GenericComs <Transaction> {

    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public List<Transaction> findById(String id) {
        return null;
    }

    @Override
    public List<Transaction> findByName(String name, String lastName) {
        return null;
    }

    @Override
    public boolean insert(Transaction object) {
        return false;
    }

    @Override
    public boolean delete(Transaction object) {
        return false;
    }

    @Override
    public boolean update(Transaction transaction) {
        return false;
    }
}
