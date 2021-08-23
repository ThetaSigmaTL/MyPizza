package com.company.model;

import com.company.model.enums.AccountStatus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private final String accountNum;
    private  Customer customer;
    private BigDecimal balance = new BigDecimal("0");
    private AccountStatus status;
    private List<Transaction> transactionsList = new ArrayList<>();

    public Account(String accountNum, BigDecimal balance, AccountStatus status, Customer customer) {

        this.accountNum = accountNum;
        this.balance = balance;
        this.status = status;
        this.customer = customer;
    }

    public boolean deposit (BigDecimal deposit){

        return (status != AccountStatus.Blocked) && (status != AccountStatus.Inactive);

    }

    public boolean withdraw (BigDecimal withdraw )
    {
        if (balance.compareTo(withdraw) == -1) {
            return false;
        }

        else return (status != AccountStatus.Blocked) && (status != AccountStatus.Inactive);
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
