package com.company.repository;

import com.company.model.*;
import com.company.model.enums.AccountStatus;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализирующий {@link AccountRep}
 * @author ThetaSigma 22.08.2021
 */
public class AccountRepImpl implements AccountRep {

    private final List<Account> accounts = new ArrayList<>();


    @Override
    public void writeAccToFile(List<Account> accounts) {

    }

    /**
     * @return возвращает банковский счет по его номеру
     */
    @Override
    public Account findAccountByAccountNum() {
        return null;
    }

    /**
     * @return возвращает все счета
     */
    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    /**
     * @return возвращает список счетов по id клиента
     */
    @Override
    public List<Account> searchByCustomerID() {
        return null;
    }

    /**
     * @return возвращает список счетов по статусу
     */
    @Override
    public List<Account> searchByAccountStatus() {
        return null;
    }

    /**
     * @return возвращает список счкетов по имени и фамилии клиента
     */
    @Override
    public List<Account> searchByFullName() {
        return null;
    }
}
