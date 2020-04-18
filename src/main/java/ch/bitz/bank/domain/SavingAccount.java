package ch.bitz.bank.domain;

public class SavingAccount extends Account {

    public SavingAccount(String accountNumber, long balance) {
        super(accountNumber, balance);
    }

    @Override
    public boolean book(int amount) {
        if (balance + amount >= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVING;
    }
}
