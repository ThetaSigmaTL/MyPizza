package com.company.test;
import com.company.model.Account;
import com.company.model.AccountNumGenerator;
import com.company.model.IdGenerator;
import com.company.model.enums.AccountStatus;
import com.company.repository.AccountDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnit.*;
import org.mockito.junit.MockitoRule;
import java.math.BigDecimal;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoRule;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountDAOTest {

    @Mock
    AccountDAO accountDAO;

    @BeforeEach void setUp(){

    }

    @Test
    void findAccountByAccountNum() {
        accountDAO.findAccountByAccountNum("11111");
    }

    @Test
    void searchByAccountStatus() {
    }

    @Test
    void getAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}