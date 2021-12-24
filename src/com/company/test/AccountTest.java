package com.company.test;
import com.company.model.Account;
import com.company.model.AccountNumGenerator;
import com.company.model.IdGenerator;
import com.company.model.enums.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
class AccountTest {
    private Account account;
    @BeforeEach
    void setUp () throws Exception{
        account = new Account(AccountNumGenerator.accountNum(), new BigDecimal("10000"), AccountStatus.Active, IdGenerator.generateID());
    }

    @Test
    void deposit() {
        account.addBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(10100),account.getBalance());
    }

    @Test
    void withdraw() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}