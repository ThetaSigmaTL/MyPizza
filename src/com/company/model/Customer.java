package com.company.model;

import com.company.repository.BankDataSourceImpl;

import java.math.BigInteger;
import java.util.List;

public class Customer extends Person{

   private final String name;
   private final String lastName;
   private final int id;
   private final Account account;
   private static int CustomerCount = 0;

    public Customer(String name,String lastName, int id, Account account) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public int generateCustomerID(){

        return CustomerCount++;

    }


}
