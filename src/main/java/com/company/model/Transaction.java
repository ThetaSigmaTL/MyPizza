package com.company.model;

import com.company.model.enums.TransactionType;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Класс транзакции
 * @author ThetaSigma 22.08.2021
 */
public class Transaction {

    private final String transactionID;
    private final String payeeAccountNum;
    private final String senderAccountNum;
    private final BigDecimal sum;
    private final TransactionType transactionType;
    private final Timestamp timestamp;

    public Transaction(String transactionID, String payeeAccountNum, String senderAccountNum, BigDecimal sum, TransactionType transactionType, Timestamp timestamp) {
        if(transactionID.length() != 36 & (payeeAccountNum.length() & senderAccountNum.length()) != 20)
            throw new IllegalArgumentException();
        if (new BigDecimal("0").compareTo(sum) == 1 | new BigDecimal("0").compareTo(sum) == 0);
        this.transactionID = transactionID;
        this.payeeAccountNum = payeeAccountNum;
        this.senderAccountNum = senderAccountNum;
        this.sum = sum;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getPayeeAccountNum() {
        return payeeAccountNum;
    }

    public String getSenderAccountNum() {
        return senderAccountNum;
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
        return transactionID == that.transactionID && payeeAccountNum == that.payeeAccountNum && senderAccountNum == that.senderAccountNum &&
                sum.equals(that.sum) && transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, payeeAccountNum, senderAccountNum, sum, transactionType);
    }
}