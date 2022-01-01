package com.company.test;

import com.company.model.Transaction;
import com.company.model.enums.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

class TransactionTest {
    Transaction transaction;
    @BeforeEach
    void setUp() throws Exception{
        transaction = new Transaction("123456789012345678901234567890123456","12345678901234567813",
                "12345678901234567890", new BigDecimal("100"),TransactionType.Transfer, new Timestamp(System.currentTimeMillis()));
    }

    @Test
    void getTransactionID() {
        assertEquals("123456789012345678901234567890123456",transaction.getTransactionID());
    }

    @Test
    void getPayeeNum() {
        assertEquals("12345678901234567813", transaction.getPayeeAccountNum());
    }

    @Test
    void getSenderNum() {
        assertEquals("12345678901234567890", transaction.getSenderAccountNum());
    }

    @Test
    void getSum() {
        assertEquals(new BigDecimal("100"), transaction.getSum());
    }

    @Test
    void getTransactionType() {
        assertEquals(TransactionType.Transfer, transaction.getTransactionType());
    }
}