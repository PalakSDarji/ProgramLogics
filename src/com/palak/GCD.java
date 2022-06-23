package com.palak;

public class GCD {

    private int findGCD(int number1, int number2){

        if(number2 == 0) return number1;

        return findGCD(number2, number1%number2);
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.findGCD(54,24));
        System.out.println(gcd.findGCD(10,45));
        System.out.println(gcd.findGCD(1701,3768));
    }
}
