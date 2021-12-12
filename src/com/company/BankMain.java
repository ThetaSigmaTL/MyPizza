package com.company;

import com.company.model.Customer;
import com.company.sqlite.DbCon;
import java.sql.*;

public class BankMain {
    public static void main(String[] args) throws SQLException {
        Customer customer = new Customer("Tom", "Handerson","123","1234567890");
    }
}




