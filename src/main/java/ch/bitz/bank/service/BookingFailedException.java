package ch.bitz.bank.service;

public class BookingFailedException extends Exception {
    public BookingFailedException(String message) {
        super(message);
    }

    public BookingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
