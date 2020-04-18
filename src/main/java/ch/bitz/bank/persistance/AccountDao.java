package ch.bitz.bank.persistance;

import ch.bitz.bank.domain.Account;

public interface AccountDao {
    Account readAccount(String accountNumber);
    void saveAccount(Account account);
}
