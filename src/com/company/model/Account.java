package com.company.model;

import com.company.model.enums.AccountStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс счета клиента клиента
 * @author ThetaSigma 22.08.2021
 */
public class Account {
    private final String accountNum;
    private final Customer customer;
    private final BigDecimal balance;
    private AccountStatus status;
    private final List<Transaction> transactionsList = new ArrayList<>();

    public Account(String accountNum, BigDecimal balance, AccountStatus status, Customer customer) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.status = status;
        this.customer = customer;
    }

    public boolean checkStatus(BigDecimal deposit){
        return (status != AccountStatus.Blocked) && (status != AccountStatus.Inactive);
    }

    public void addBalance(BigDecimal deposit){
        if (deposit != null){
            balance.add(deposit);
        }
    }

    public void subBalance(BigDecimal withdraw) {
        if (withdraw != null){
            balance.subtract(withdraw);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccount() {

        return accountNum;
    }


    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNum.equals(account.accountNum) && customer.equals(account.customer) && balance.equals(account.balance)
                && status == account.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNum, customer, balance, status);
    }
}
