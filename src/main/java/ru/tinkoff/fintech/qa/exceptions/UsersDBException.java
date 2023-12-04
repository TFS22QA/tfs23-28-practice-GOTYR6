package ru.tinkoff.fintech.qa.exceptions;

public class UsersDBException extends RuntimeException {
    public UsersDBException(String message) {
        super(message);
    }
}
