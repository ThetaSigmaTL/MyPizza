package com.company.model;

import com.company.model.enums.Position;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс сотрудника
 * @author ThetaSigma 22.08.2021
 */
public class Employee extends Person {
    private String firstName;
    private String lastName;
    private String id;
    BigDecimal salary;
    private Position position;

    public Employee(String firstName, String lastName, String id, BigDecimal salary, Position position) {
        super(firstName, lastName, id);
        this.salary = salary;
        this.position = position;
    }


    @Override
    public String getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && id.equals(employee.id) &&
                salary.equals(employee.salary) && position == employee.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, salary, position);
    }
}

