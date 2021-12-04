package com.company.repository;

import com.company.model.Employee;
import com.company.sqlite.GenericComs;

import java.util.List;

public class EmployeeRepImp implements GenericComs <Employee> {


    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public List<Employee> findById(String id) {
        return null;
    }

    @Override
    public List <Employee> findByName(String name, String lastName) {
        return null;
    }

    @Override
    public boolean insert (Employee employee) {
        return false;
    }

    @Override
    public  boolean delete(Employee employee) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
