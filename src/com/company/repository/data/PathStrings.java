package com.company.repository.data;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathStrings {
    public static String currentAppPathString = Paths.get("").toAbsolutePath().toString();

    public static String accountsFIlePathString = currentAppPathString + File.separator + "src" + File.separator + "com"
            + File.separator + "company" + File.separator + "resources" + File.separator + "Accounts.csv";

    public static String customersFilePathString = currentAppPathString + File.separator + "src" + File.separator + "com"
            + File.separator + "company" + File.separator + "resources" + File.separator + "Customer.csv";

    public static String employeesFilePathString = currentAppPathString + File.separator + "src" + File.separator + "com"
            + File.separator + "company" + File.separator + "resources" + File.separator + "Employees.csv";

    public static String transactionsFilePathString = currentAppPathString + File.separator + "src" + File.separator + "com"
            + File.separator + "company" + File.separator + "resources" + File.separator + "Transactions.csv";

}
