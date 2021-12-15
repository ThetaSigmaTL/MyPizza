package com.company;

import com.company.menus.CustomerMenu;
import com.company.model.Customer;
import com.company.model.IdGenerator;
import com.company.model.enums.TransactionType;
import com.company.sqlite.DbCon;
import org.junit.platform.commons.function.Try;

import java.sql.*;
import java.util.UUID;

public class BankMain {
    public static void main(String[] args) throws SQLException {
        String b = "Atm";
        boolean a = b.equalsIgnoreCase(TransactionType.ATM.toString());
        System.out.println(a);
    }
}




