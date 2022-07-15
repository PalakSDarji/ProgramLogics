package com.palak.java;

public class ExceptionPlay {
    public static void main(String[] args) {

        try{
            int i = 2/0;
        }catch (RuntimeException e){
            //dont do anything to swallow Runtime exception.
        }

        try {
            throwException();
        } catch (Exception e) {
            //e.printStackTrace();
        }

        try{
            throwError();
        }
        catch (Error e){

        }

        System.out.println("passed exception");
    }

    private static void throwException() throws Exception{
        throw new RuntimeException("sample exception");
    }

    private static void throwError() {
        throw new Error("sample exception");
    }
}
