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

    public static int generateId(){
        int min = 0;
        int max = 1000000000;
        return (int) Math.floor(Math.random()*(max-min+1)+min);

    }
}
