package com.palak;

public class FactorialDemo {

    private long findFactorial(int number) {

        if(number == 0){
            return 1;
        }

        return number * findFactorial(number - 1);
    }

    public static void main(String[] args) {
        FactorialDemo factorialDemo = new FactorialDemo();
        System.out.println(factorialDemo.findFactorial(20));
    }
}
