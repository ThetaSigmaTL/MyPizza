package com.company;
import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.repository.BankDataSource;
import com.company.repository.BankDataSourceImpl;
import com.company.model.Person;
import java.math.BigInteger;
import java.util.List;

public class Main {

    public static void main(String[] args)  {
        int a = Person.generateId();
        System.out.print(a);

    }
}
