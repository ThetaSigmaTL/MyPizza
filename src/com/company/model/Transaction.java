package com.company.model;

import com.company.model.enums.TransactionType;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * Класс транзакции
 * @author ThetaSigma 22.08.2021
 */
public class Transaction {

    private final String transactionID;
    private final String payeeID;
    private final String senderID;
    private final BigDecimal sum;
    private final TransactionType transactionType;
    private final Timestamp timestamp;

    public Transaction(String transactionID, String payeeID, String senderID, BigDecimal sum, TransactionType transactionType, Timestamp timestamp) {
        this.transactionID = transactionID;
        this.payeeID = payeeID;
        this.senderID = senderID;
        this.sum = sum;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getPayeeID() {
        return payeeID;
    }

    public String getSenderID() {
        return senderID;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionID == that.transactionID && payeeID == that.payeeID && senderID == that.senderID &&
                sum.equals(that.sum) && transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, payeeID, senderID, sum, transactionType);
    }
}