package ch.bitz.bank.domain;

public class CreditAccount extends Account {
    private int creditLine;

    public CreditAccount(String accountNumber, long balance, int creditLine) {
        super(accountNumber, balance);
        this.creditLine = creditLine;
    }

    @Override
    public boolean book(int amount) {
        if (balance + amount >= creditLine) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CREDIT;
    }

    public int getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(int creditLine) {
        this.creditLine = creditLine;
    }
}
