package com.company.repository;

import com.company.model.Customer;
import com.company.sqlite.GenericComs;

import java.util.List;

public class CustomerRepImpl implements GenericComs <Customer> {

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public List<Customer> findById(String id) {
        return null;
    }

    @Override
    public List<Customer> findByName(String name, String lastName) {
        return null;
    }

    @Override
    public  boolean insert(Customer customer) {
        return false;
    }

    @Override
    public  boolean delete(Customer customer) {
        return false;
    }

    @Override
    public  boolean update() {
        return false;
    }
}
