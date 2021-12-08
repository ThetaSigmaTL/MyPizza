package com.company.model;

import java.util.List;
import java.util.Objects;

/**
 * Класс клиента
 * @author ThetaSigma 22.08.2021
 */
public class Customer {

   private final String firstName;
   private final String lastName;
   private final String id;
   private final String passID;
   private List<Account> accounts;

    public Customer(String firstName,String lastName, String id, String passID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.passID = passID;

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

    public String getPassID() {
        return passID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && id.equals(customer.id)
                && passID.equals(customer.passID) && accounts.equals(customer.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, passID, accounts);
    }

    public List<Account> getAccounts() {

        return accounts;

    }


}
