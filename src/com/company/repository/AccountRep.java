package com.company.repository;

import com.company.model.Account;
import java.util.List;

/**
 * Интерфейс для обработки счетов клиентов
 * @author ThetaSigma 22.08.2021
 */

public interface AccountRep {

    void writeAccToFile(List <Account> accounts);

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
