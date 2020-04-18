package ch.bitz.bank.service;

import ch.bitz.bank.domain.Account;
import ch.bitz.bank.persistance.AccountDao;

public class BankService {
    private AccountDao accountDao;

    public BankService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private void transfer(String sender, String receiver, int amount) throws BookingFailedException {
        if(sender == null || receiver == null || amount < 0) {
            throw new IllegalArgumentException();
        }

        Account senderAccount = accountDao.readAccount(sender);
        Account receiverAccount = accountDao.readAccount(receiver);

        if(senderAccount == null || receiverAccount == null) {
            throw new IllegalArgumentException();
        }

        if(senderAccount.book(-amount)) {
            receiverAccount.book(amount);
        } else {
            throw new BookingFailedException("Sender doesn't have enough amount of cash to transfer.");
        }
    }

    protected void transfer(Account sender, Account receiver, int amount) throws BookingFailedException {
        if(sender == null || receiver == null || amount < 0) {
            throw new IllegalArgumentException();
        }

        if(sender.book(-amount)) {
            receiver.book(amount);
        } else {
            throw new BookingFailedException("Sender doesn't have enough amount of cash to transfer.");
        }
    }

    public void persistAccount(Account account) {
        accountDao.saveAccount(account);
    }


}
