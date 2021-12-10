package com.company;

import com.company.model.Account;
import com.company.repository.AccountRepImpl;
import com.company.sqlite.DbCon;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) throws SQLException {
        Scanner inputName = new Scanner(System.in);
        System.out.println("Enter firstname");
        String name = inputName.nextLine();
        System.out.println("Enter lastname");
        String lastname = inputName.nextLine();
        System.out.println(name + " " + lastname);
    }
}




