package com.company.model;

import com.company.model.enums.TransactionType;

import java.math.BigDecimal;

public class Transaction {

    private final int transactionID;
    private final int payeeID;
    private final int senderID;
    private final BigDecimal sum;
    private final TransactionType transactionType;

    public Transaction(int transactionID, int payeeID, int senderID, BigDecimal sum, TransactionType transactionType) {
        this.transactionID = transactionID;
        this.payeeID = payeeID;
        this.senderID = senderID;
        this.sum = sum;
        this.transactionType = transactionType;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public int getPayeeID() {
        return payeeID;
    }

    public int getSenderID() {
        return senderID;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}