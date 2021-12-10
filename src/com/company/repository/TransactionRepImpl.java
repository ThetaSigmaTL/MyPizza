package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;
import com.company.model.enums.AccountStatus;
import com.company.model.enums.TransactionType;
import com.company.sqlite.DbCon;
import com.company.sqlite.GenericComs;
import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepImpl implements GenericComs <Transaction, Transaction> {

    @Override
    public List<Transaction> getAll() {
        Connection conn = DbCon.getConnection();
        String command = "Select * From Transactions";
        List<Transaction> transactions = new ArrayList<>();
        try {
            PreparedStatement select_cammand = (PreparedStatement) conn.prepareStatement(command);
            ResultSet resultSet = select_cammand.executeQuery();
            while (resultSet.next()){
                String transactionId = resultSet.getString("TransactionId");
                String payeeId = resultSet.getString("PayeeId");
                String senderId = resultSet.getString("SenderId");
                BigDecimal sum = new BigDecimal(resultSet.getString("Sum"));
                TransactionType transactionType = TransactionType.valueOf(resultSet.getString("TransactionType"));
                Timestamp timestamp = resultSet.getTimestamp("TimeStamp");
                transactions.add(new Transaction(transactionId,payeeId,senderId,sum,transactionType,timestamp));
            }
            resultSet.close();
            select_cammand.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbCon.closeConnection(conn);
        }
        return transactions;
    }

    @Override
    public Transaction findById(String findId) {
        Connection conn = DbCon.getConnection();
        String command = "Select * from Transactions where TransactionId = '" + findId + "'";
        Statement statement = null;
        Transaction transaction = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                String transactionId = resultSet.getString("TransactionId");
                String payeeId = resultSet.getString("PayeeId");
                String senderId = resultSet.getString("SenderId");
                BigDecimal sum = new BigDecimal(resultSet.getString("Sum"));
                TransactionType transactionType = TransactionType.valueOf(resultSet.getString("TransactionType"));
                Timestamp timestamp = resultSet.getTimestamp("TimeStamp");
                transaction = new Transaction(transactionId,payeeId,senderId,sum,transactionType,timestamp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public List<Transaction> findByName(String name, String lastName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean insert(Transaction transaction) {
        Connection conn = DbCon.getConnection();
        boolean result = false;
        String transactionId = transaction.getTransactionID();
        String payeeId = transaction.getPayeeID();
        String senderId = transaction.getSenderID();
        String sum = transaction.getSum().toString();
        String transactionType = transaction.getTransactionType().toString();
        String timeStamp = transaction.getTimestamp().toString();
        String command = String.format("Insert into Transactions (TransactionId, PayeeId, SenderId, Sum, transactionType, TimeStamp)"
                        +  "values ('%s', '%s', '%s', '%s', '%s', '%s')", transactionId, payeeId, senderId, sum,transactionType, timeStamp);
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
    public boolean delete(Transaction transaction) {
        Connection conn = DbCon.getConnection();
        String command = String.format("Delete from Transactions where TransactionId  = '%s' AND Sum= '%s'", transaction.getTransactionID(),
                transaction.getSum());
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
    public boolean update(Transaction transaction) {
        return false;
    }
}
