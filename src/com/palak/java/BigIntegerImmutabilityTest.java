package com.palak.java;

import java.math.BigInteger;

public class BigIntegerImmutabilityTest {
    public static void main(String[] args) {

        BigInteger sum = BigInteger.valueOf(0);

        for(int i=0;i<10;i++){
            sum.add(BigInteger.valueOf(i));
        }
        System.out.println(sum.intValue()); //0

    }
}
