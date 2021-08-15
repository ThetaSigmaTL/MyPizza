package com.company.model;

import com.company.model.enums.AccountStatus;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Account {
    private final BigInteger account;
    private final int customerID;
    private final String customerName;
    private final String customerLastname;
    private BigDecimal balance;
    private AccountStatus status;

    public Account(BigInteger account, String customerName,String customerLastname,int customerID,
                   BigDecimal balance, AccountStatus status) {

        this.account = account;
        this.customerName= customerName;
        this.customerLastname = customerLastname;
        this.customerID = customerID;
        this.balance = balance;
        this.status = status;
    }

    public void deposit (BigDecimal deposit){
        this.balance.add(deposit);
    }

    public void withdraw (BigDecimal withdraw )
    {
        this.balance.subtract(withdraw);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigInteger getAccount() {
        return account;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
