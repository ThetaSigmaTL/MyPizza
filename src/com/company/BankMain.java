package com.company;

import com.company.model.Account;
import com.company.repository.AccountRepImpl;
import com.company.sqlite.DbCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankMain {

    public static void main(String[] args) throws SQLException {
        String accountNum = "world";
        String customerId = "Hello";
        String Balance = "No";
        String Status = "Way";
        String alpa =  String.format("Insert into Accounts (AccountNum, CustomerId, Balance, Status)" +  "values ('%s', '%s', '%s', '%s')",
                accountNum, customerId, Balance, Status);
        System.out.println(alpa);
    }
}



