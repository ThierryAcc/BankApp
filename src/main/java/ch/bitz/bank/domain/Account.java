package ch.bitz.bank.domain;

public abstract class Account {
    private String accountNumber;
    protected long balance;

    public abstract boolean book(int amount);
    public abstract AccountType getAccountType();

    public Account(String accountNumber, long balance) {
        if(accountNumber == null || accountNumber.length() < 9 || !accountNumber.matches("\\d+")) {
            throw new IllegalArgumentException();
        } else {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
