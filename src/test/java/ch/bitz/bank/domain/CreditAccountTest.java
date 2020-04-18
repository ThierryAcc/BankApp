package ch.bitz.bank.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditAccountTest {
    private Account account;
    private String ACCOUNTNUMBER = "123456789";

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeCreditLine() {
        account = new CreditAccount(null, 0, -1);
    }

    @Test
    public void bookInvalid() {
        account = new CreditAccount(ACCOUNTNUMBER, 0, 1000);
        assertFalse(account.book(-1001));
    }

    @Test
    public void bookValid() {
        account = new CreditAccount(ACCOUNTNUMBER, 0, 1000);
        assertTrue(account.book(+1000));
    }
}