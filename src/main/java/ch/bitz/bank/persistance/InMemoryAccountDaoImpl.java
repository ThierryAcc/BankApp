package ch.bitz.bank.persistance;

import ch.bitz.bank.domain.Account;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountDaoImpl implements AccountDao {
    private Map<String, Account> accountMap;

    public InMemoryAccountDaoImpl() {
        accountMap = new HashMap<>();
    }

    @Override
    public Account readAccount(String accountNumber) {
        if(accountMap.get(accountNumber) == null) {
            throw new NullPointerException();
        }
        return accountMap.get(accountNumber);
    }

    @Override
    public void saveAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }
}
