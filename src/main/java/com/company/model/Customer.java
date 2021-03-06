package com.company.model;

/**
 * Класс клиента
 * @author ThetaSigma 22.08.2021
 */
public class Customer {

   private final String firstName;
   private final String lastName;
   private final String id;
   private final  String passNum;


    public Customer(String firstName, String lastName, String id, String passNum) {
        if (id.length() != 36 || passNum.length() != 10){
            throw new IllegalArgumentException("Id or passport number is not valid");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.passNum = passNum;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getPassNum() {
        return passNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && id.equals(customer.id)
                && passNum.equals(customer.passNum);
    }




}
