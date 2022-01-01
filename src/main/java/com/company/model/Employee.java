package com.company.model;

import com.company.model.enums.Position;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс сотрудника
 * @author ThetaSigma 22.08.2021
 */
public class Employee  {
    private final String firstName;
    private final String lastName;
    private final String id;
    private final BigDecimal salary;
    private final Position position;

    public Employee(String firstName, String lastName, String id, BigDecimal salary, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.salary = salary;
        this.position = position;
    }

    public Position getPosition() {
        return position;
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

