package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRep {

    void writeCustomerToFile(List <Account> accounts);

    /**
     * @return  возвращает банковский счет по его номеру
     */
    Customer findCustomerByName();

    /**
     * @return возвращает все счета
     */
    List<Customer> getAllCustomers();

    /**
     * @return возвращает список счетов по id клиента
     */

    List<Customer> searchByCustomerPassId();

    /**
     * @return возвращает список счетов по статусу
     */

    List<Customer> searchByAccountStatus();

    /**
     * @return возвращает список счкетов по имени и фамилии клиента клиента
     */
    List<Customer> searchByFullName();

}
