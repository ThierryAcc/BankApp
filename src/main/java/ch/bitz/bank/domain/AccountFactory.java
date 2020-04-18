package ch.bitz.bank.domain;

public class AccountFactory {

    public static Account createAccount(String accountNumber, long balance, int creditLine, AccountType accountType) {
        switch (accountType) {
            case BAD:
                return new BadAccount(accountNumber, balance);
            case SAVING:
                return new SavingAccount(accountNumber, balance);
            case CREDIT:
                return new CreditAccount(accountNumber, balance, creditLine);
            default:
                return null;
        }
    }
}
