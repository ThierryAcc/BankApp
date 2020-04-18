package ch.bitz.bank.persistance;

import ch.bitz.bank.domain.Account;
import ch.bitz.bank.domain.AccountFactory;
import ch.bitz.bank.domain.AccountType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InMemoryAccountDaoImplTest {
    private InMemoryAccountDaoImpl dao = new InMemoryAccountDaoImpl();
    Account account1;
    Account account2;
    Account account3;

    @Before
    public void setUp() {
        account1 = AccountFactory.createAccount("111111111", 0, 0, AccountType.BAD);
        account2 = AccountFactory.createAccount("111111112", 0, 0, AccountType.SAVING);
        account3 = AccountFactory.createAccount("111111113", 0, 0, AccountType.CREDIT);
    }

    @Test
    public void readAccountValid() {
        dao.saveAccount(account1);
        dao.saveAccount(account2);
        assertEquals(dao.readAccount("111111112"), account2);
    }

    @Test(expected = NullPointerException.class)
    public void readAccountNull() {
        dao.readAccount(null);
    }

    @Test(expected = NullPointerException.class)
    public void readAccountNonExistant() {
        dao.readAccount("123");
    }

    @Test
    public void saveAccountValid() {
        Map<String, Account> accountMap = new HashMap<>();
        accountMap.put(account1.getAccountNumber(), account1);
        accountMap.put(account2.getAccountNumber(), account2);
        dao.saveAccount(account1);
        dao.saveAccount(account2);
        assertEquals(accountMap.get(account2.getAccountNumber()), dao.readAccount(account2.getAccountNumber()));
    }
}