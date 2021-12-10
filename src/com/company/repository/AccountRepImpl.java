package com.company.repository;

import com.company.model.*;
import com.company.model.enums.AccountStatus;
import com.company.sqlite.DbCon;
import com.company.sqlite.GenericComs;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализирующий {@link GenericComs}
 * @author ThetaSigma 22.08.2021
 */
public class AccountRepImpl implements GenericComs <Account, List>  {

    private final List<Account> accounts = new ArrayList<>();

    /**
     * @return возвращает банковский счет по его номеру
     */
    public Account findAccountByAccountNum(String AccountNum) {
        Connection conn = DbCon.getConnection();
        String command = "Select * from Accounts where AccountNum = '" + AccountNum + "'";
        Statement statement = null;
        Account account = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                String accountNum = resultSet.getString("AccountNum");
                String customerId = resultSet.getString("CustomerId");
                BigDecimal balance = new BigDecimal(resultSet.getString("Balance"));
                AccountStatus status = AccountStatus.valueOf(resultSet.getString("Status"));
                account = new Account(accountNum, balance, status,customerId);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    /**
     * @return возвращает список счетов по статусу
     */
    public List<Account> searchByAccountStatus(AccountStatus status) {
        Connection conn = DbCon.getConnection();
        String command = "Select * from Accounts where AccountNum = '" + status.toString() + "'";
        Statement statement = null;
        List<Account> account = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                String accountNum = resultSet.getString("AccountNum");
                String customerId = resultSet.getString("CustomerId");
                BigDecimal balance = new BigDecimal(resultSet.getString("Balance"));
                AccountStatus accountStatus = AccountStatus.valueOf(resultSet.getString("Status"));
                account.add(new Account(accountNum, balance, status,customerId));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> getAll() {
        Connection conn = DbCon.getConnection();
        String command = "Select * From accounts";
        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement select_cammand = (PreparedStatement) conn.prepareStatement(command);
            ResultSet resultSet = select_cammand.executeQuery();
            while (resultSet.next()){
                Account temp;
                String accountNum = resultSet.getString("AccountNum");
                String customerId = resultSet.getString("CustomerId");
                BigDecimal balance = new BigDecimal(resultSet.getString("Balance"));
                AccountStatus accountStatus = AccountStatus.valueOf(resultSet.getString("Status"));
                temp = new Account(accountNum,balance,accountStatus,customerId);
                accounts.add(temp);
            }
            resultSet.close();
            select_cammand.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbCon.closeConnection(conn);
        }
        return accounts;
    }

    @Override
    public List<Account> findById(String id) {
        Connection conn = DbCon.getConnection();
        String command = "Select * from Accounts where CustomerId = '" + id + "'";
        List<Account> accounts = new ArrayList<>();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                String accountNum = resultSet.getString("AccountNum");
                String customerId = resultSet.getString("CustomerId");
                BigDecimal balance = new BigDecimal(resultSet.getString("Balance"));
                AccountStatus status = AccountStatus.valueOf(resultSet.getString("Status"));
                accounts.add(new Account(accountNum, balance, status,customerId));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> findByName(String name, String lastName) {
        return  null;
    }

    @Override
    public boolean insert(Account account) {
        Connection conn = DbCon.getConnection();
        String accountNum = account.getAccountNum();
        String customerId = account.getCustomerId();
        String Balance = account.getBalance().toString();
        String Status = account.getStatus().toString();
        String command = String.format("Insert into Accounts (AccountNum, CustomerId, Balance, Status)" +  "values ('%s', '%s', '%s', '%s')",
                accountNum, customerId, Balance, Status);
        boolean result = false;
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(command);
            result = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result ;
    }

    @Override
    public boolean delete(Account account) {
        Connection conn = DbCon.getConnection();
        String accountNum = account.getAccountNum();
        String customerId = account.getCustomerId();
        String command = String.format("Delete from Accounts where AccountNum = '%s' AND CustomerId = '%s'", accountNum, customerId);
        boolean result = false;
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(command);
            result = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result ;
    }

    @Override
    public boolean update(Account account) {
        Connection conn = DbCon.getConnection();
        boolean result = false;
        try {
            Statement statement = null;
            String command = String.format("Update Accounts set CustomerId = '%s', Balance = '%s', Status = '%s' where AccountNum = '%s'",
                    account.getCustomerId(), account.getBalance(), account.getStatus(), account.getAccountNum());
            ResultSet rs = statement.executeQuery(command);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
