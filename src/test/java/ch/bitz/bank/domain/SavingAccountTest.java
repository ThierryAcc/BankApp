package ch.bitz.bank.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingAccountTest {
    private Account account;
    private String ACCOUNTNUMBER = "123456789";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNull() {
        account = new SavingAccount(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeBalance() {
        account = new SavingAccount(null, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLessThanNineDigits() {
        account = new SavingAccount("123", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLettersInsteadOfDigits() {
        account = new SavingAccount("abcdefghijk", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLettersAndDigits() {
        account = new SavingAccount("abcdef123ghijk", 0);
    }

    @Test
    public void bookInvalid() {
        account = new SavingAccount(ACCOUNTNUMBER, 0);
        assertFalse(account.book(-1));
    }

    @Test
    public void bookValid() {
        account = new SavingAccount(ACCOUNTNUMBER, 1);
        assertTrue(account.book(-1));
        assertTrue(account.book(+1));
    }
}