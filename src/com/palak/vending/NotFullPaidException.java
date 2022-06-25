package com.palak.vending;

public class NotFullPaidException extends Exception {

    private String message;

    public NotFullPaidException(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
