package com.company.model;

import java.util.UUID;

public abstract class Person {
    private String name = null;

    private int id = 0;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
