package com.company.repository;

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
    public boolean insert(Transaction transaction) {
        return false;
    }

    @Override
    public boolean delete(Transaction transaction) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
