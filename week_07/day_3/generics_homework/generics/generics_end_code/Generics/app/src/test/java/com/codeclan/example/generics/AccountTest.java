package com.codeclan.example.generics;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AccountTest {

    Account<Integer> account1;
    Account<String> account2;

    @Before
    public void before() {
        account1 = new Account<Integer>(1234, "Jennifer Saunders");
        account2 = new Account<String>("CC99XX", "Joanna Lumley");
    }

    @Test
    public void testGetIdInteger() {
        Integer id = 1234;
        assertEquals(id, account1.getId());
    }

    @Test
    public void testGetIdString() {
        String id = "CC99XX";
        assertEquals(id, account2.getId());
    }


}
