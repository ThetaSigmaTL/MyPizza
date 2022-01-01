package com.company.repository;

import com.company.model.Account;
import com.company.model.Employee;
import com.company.model.enums.AccountStatus;
import com.company.model.enums.Position;
import com.company.sqlite.DbCon;
import com.company.sqlite.GenericComs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements GenericComs <Employee, Employee> {


    @Override
    public List<Employee> getAll() {
        Connection conn = DbCon.getConnection();
        String command = "Select * From employees";
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(command);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee temp;
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String id = resultSet.getString("Id");
                String passId = resultSet.getString("PassId");
                BigDecimal salary = new BigDecimal(resultSet.getString("Salary"));
                Position position = Position.valueOf(resultSet.getString("Position"));
                temp = new Employee(firstName,lastName,id,salary,position);
                employees.add(temp);
            }
            resultSet.close();
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbCon.closeConnection(conn);
        }
        return employees;
    }

    @Override
    public Employee findById(String id) {
        Connection conn = DbCon.getConnection();
        String command = String.format("Select * from Employees where Id = '%s'", id);
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(command);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee temp;
            }
        }
        catch (SQLException e){

        }
        return null;
    }

    @Override
    public List <Employee> findByName(String name, String lastName) {
        return null;
    }

    @Override
    public boolean insert(Employee object) {
        return false;
    }

    @Override
    public  boolean delete(Employee object) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }
}
