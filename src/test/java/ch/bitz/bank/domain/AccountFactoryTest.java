package ch.bitz.bank.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountFactoryTest {
    private String ACCOUNTNUMBER = "123456789";

    @Test
    public void createBadAccount() {
        Account account = AccountFactory.createAccount(ACCOUNTNUMBER, 0, 0, AccountType.BAD);
        BadAccount badAccount = (account instanceof BadAccount) ? ((BadAccount) account) : null;
        assertNotNull(badAccount);
    }

    @Test
    public void createSavingAccount() {
        Account account = AccountFactory.createAccount(ACCOUNTNUMBER, 0, 0, AccountType.SAVING);
        SavingAccount savingAccount = (account instanceof SavingAccount) ? ((SavingAccount) account) : null;
        assertNotNull(savingAccount);
    }

    @Test
    public void createCreditAccount() {
        Account account = AccountFactory.createAccount(ACCOUNTNUMBER, 0, 0, AccountType.CREDIT);
        CreditAccount creditAccount = (account instanceof CreditAccount) ? ((CreditAccount) account) : null;
        assertNotNull(creditAccount);
    }

}