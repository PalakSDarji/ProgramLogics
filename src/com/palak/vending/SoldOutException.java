package com.palak.vending;

public class SoldOutException extends Exception{
    private String message;

    public SoldOutException(String m){
        message = m;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
