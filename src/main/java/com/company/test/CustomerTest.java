package com.company.test;

import com.company.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    @BeforeEach
    void setUp() throws Exception{
        customer = new Customer("Jon","Snow", "123456789012345678901234567890123456","1810123456");
    }

    @Test
    void getFirstName() {
        assertEquals("Jon",customer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Snow",customer.getLastName());
    }

    @Test
    void getId() {
        assertEquals("123456789012345678901234567890123456", customer.getId());
    }

    @Test
    void getPassNum() {
        assertEquals("1810123456", customer.getPassNum());
    }

    @Test
    void testEquals() {
    }
}