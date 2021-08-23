package com.company.model;

/**
 * Абстрактный класс человека
 * @author ThetaSigma 22.08.2021
 */
public abstract class Person {

    private String firstName;
    private String lastName;
    private String id;

    public Person(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public Person() {

    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
