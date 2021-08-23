package com.company.model;

import com.company.model.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс транзакции
 * @author ThetaSigma 22.08.2021
 */
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