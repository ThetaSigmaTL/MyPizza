package com.company.model;

import java.util.List;
import java.util.Objects;

/**
 * Класс клиента
 * @author ThetaSigma 22.08.2021
 */
public class Customer extends Person{

   private String firstName;
   private String lastName;
   private String id;
   private String passID;
   private List<Account> accounts;

    public Customer(String firstName,String lastName, String id, String passID) {
        super(firstName, lastName, id);
        this.passID = passID;
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
