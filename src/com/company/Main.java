package com.company;
import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.repository.data.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSourceImpl(new Abc());

    }
}
