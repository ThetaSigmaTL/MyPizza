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
   private final  String passNum;
   private List<Account> accounts;

    public Customer(String firstName,String lastName, String id, String passNum) {
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
                && passNum.equals(customer.passNum) && accounts.equals(customer.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, passNum, accounts);
    }

    public List<Account> getAccounts() {

        return accounts;

    }


}
