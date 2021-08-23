package com.company.repository;

import com.company.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepImpl {

    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers()
    {
        return customers;
    };
}
