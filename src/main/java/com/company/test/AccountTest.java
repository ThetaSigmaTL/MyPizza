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
        account = new Account("12345678901234567890", new BigDecimal("10000"), AccountStatus.Active, IdGenerator.generateID());
    }

    @Test
    void deposit() {
        account.addBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(10100),account.getBalance());
    }

    @Test
    void withdraw() {
        account.subBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(9900), account.getBalance());
    }

    @Test
    void getBalance() {
        assertEquals(new BigDecimal(10000), account.getBalance());
    }

    @Test
    void getAccount() {
        assertEquals("12345678901234567890", account.getAccountNum());
    }

    @Test
    void getStatus() {
        assertEquals(AccountStatus.Active, account.getStatus());
    }

    @Test
    void setStatus() {
        account.setStatus(AccountStatus.Blocked);
        assertEquals(AccountStatus.Blocked,account.getStatus());
    }

    @Test
    void testEquals() {

    }

    @Test
    void testHashCode() {
    }
}