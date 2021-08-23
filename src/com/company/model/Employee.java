package com.company.model;

import com.company.model.enums.Position;

import java.math.BigDecimal;

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
}

