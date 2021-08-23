package com.company.repository;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.model.Transaction;

import java.util.List;

/**
 * Интерфейс для обработки счетов клиентов
 * @author ThetaSigma
 * @since 22.08.2021
 */

public interface AccountRep {


    /**
     * @return  возвращает банковский счет по его номеру
     */
    Account findAccountByAccountNum();

    /**
     * @return возвращает все счета
     */
    List<Account> getAllAccounts();

    /**
     * @return возвращает список счетов по id клиента
     */

    List<Account> searchByCustomerID();

    /**
     * @return возвращает список счетов по статусу
     */

    List<Account> searchByAccountStatus();

    /**
     * @return возвращает список счкетов по имени и фамилии клиента клиента
     */
    List<Account> searchByFullName();


}
