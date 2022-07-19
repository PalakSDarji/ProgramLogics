package com.palak.java;

public class CheckInnerPlay {

    private void doCheck(){
        InnerPlay.Inner1 inner1 = new InnerPlay.Inner1();
        inner1.doInnerStaticTest();
    }

    public static void main(String[] args) {

        InnerPlay.Inner1 inner1 = new InnerPlay.Inner1();
        inner1.doInnerStaticTest();

    }
}
