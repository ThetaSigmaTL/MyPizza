package com.company.model;

import com.company.model.enums.AccountStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс счета  клиента
 * @author ThetaSigma 22.08.2021
 */
public class Account {
    private final String accountNum;
    private final String customerId;
    private  BigDecimal balance;
    private AccountStatus status;
    private final List<Transaction> transactionsList = new ArrayList<>();


    public Account(String accountNum, BigDecimal balance, AccountStatus status, String customerId) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.status = status;
        this.customerId = customerId;
    }

    public boolean checkStatus(BigDecimal deposit){
        return (status != AccountStatus.Blocked) && (status != AccountStatus.Inactive);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void addBalance(BigDecimal deposit){
        if (deposit != null){
           balance = balance.add(deposit);
        }
    }

    public void subBalance(BigDecimal withdraw)  {
        if (withdraw != null & (withdraw.compareTo(balance) != 1)){
            balance = balance.subtract(withdraw);
        }
    }

    public String getAccountNum() {
        return accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
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
        return accountNum.equals(account.accountNum) && customerId.equals(account.customerId) && balance.equals(account.balance)
                && status == account.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNum, customerId, balance, status);
    }
}
