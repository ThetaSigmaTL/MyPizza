package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.enums.AccountStatus;
import com.company.sqlite.DbCon;
import com.company.sqlite.GenericComs;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepImpl implements GenericComs <Customer> {

    public Customer findByPassId(String idToFind){
        Connection conn = DbCon.getConnection();
        String command = String.format("Select * from Customers where PassId = '%s'", idToFind );
        Statement statement;
        Customer result = null;
        try{
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){

                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String id = resultSet.getString("Id");
                String passId = resultSet.getString("PassId");
                result = new Customer(firstName,lastName,id,passId);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List<Customer> getAll() {
        Connection conn = DbCon.getConnection();
        String command = "Select * From Customers";
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement selectCommand = (PreparedStatement) conn.prepareStatement(command);
            ResultSet resultSet = selectCommand.executeQuery();
            while (resultSet.next()){
                Customer temp;
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String id = resultSet.getString("Id");
                String passId = resultSet.getString("PassId");
                temp = new Customer(firstName,lastName,id,passId);
                customers.add(temp);
            }
            resultSet.close();
            selectCommand.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbCon.closeConnection(conn);
        }
        return customers;
    }

    @Override
    public List<Customer> findById(String findId){
        Connection conn = DbCon.getConnection();
        String command = "Select * from Accounts where CustomerId = '" + findId + "'";
        List<Customer> customers = new ArrayList<>();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String id = resultSet.getString("Id");
                String passId = resultSet.getString("PassId");
                customers.add(new Customer(firstName, lastName, id,passId));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<Customer> findByName(String firstNameToFind, String lastNameToFind) {
        Connection conn = DbCon.getConnection();
        String command = String.format("Select * from Customers where FirstName = '%s' and LastName = '%s'", firstNameToFind, lastNameToFind);
        List<Customer> customers = new ArrayList<>();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String id = resultSet.getString("Id");
                String passId = resultSet.getString("PassId");
                customers.add(new Customer(firstName, lastName, id,passId));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public  boolean insert(Customer customer) {
        Connection conn = DbCon.getConnection();
        String command = String.format("Insert into Customers (FirstName, LastName, Id, PassId)" + "values ('%s', '%s','%s','%s')",
                customer.getFirstName(),customer.getLastName(),customer.getId(),customer.getPassID());
        boolean result = false;
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(command);
            result = true;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public  boolean delete(Customer customer) {
        Connection conn = DbCon.getConnection();
        String command = String.format("Delete from Customers where Id  = '%s' AND PassId= '%s'", customer.getId(), customer.getPassID());
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
    public  boolean update(Customer customer) {
        Connection conn = DbCon.getConnection();
        boolean result = false;
        try {
            Statement statement = null;
            String command = String.format("Update Customers set FirstName = '%s' and LastName = '%s' where Id = '%s'",
                    customer.getFirstName(), customer.getLastName());
            ResultSet rs = statement.executeQuery(command);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }


}
