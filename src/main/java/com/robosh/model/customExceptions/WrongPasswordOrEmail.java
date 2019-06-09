package com.robosh.model.customExceptions;

public class WrongPasswordOrEmail extends Exception {
    public WrongPasswordOrEmail() {
    }

    public WrongPasswordOrEmail(String message) {
        super(message);
    }

    public WrongPasswordOrEmail(Throwable throwable) {
        super(throwable);
    }

    public WrongPasswordOrEmail(String message, Throwable throwable) {
        super(message, throwable);
    }
}
