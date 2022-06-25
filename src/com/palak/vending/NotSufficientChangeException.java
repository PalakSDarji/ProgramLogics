package com.palak.vending;

public class NotSufficientChangeException extends Exception {

    private String message;

    public NotSufficientChangeException(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
