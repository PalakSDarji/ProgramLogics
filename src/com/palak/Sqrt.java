package com.palak;

public class Sqrt {

    //153 = 1^3 + 5^3 +3^3
    private void armstrong(int number){

        int addition = 0;
        int org = number;

        while(number > 0) {
            int rem = number%10;
            addition = addition + (rem * rem * rem);
            number = number/10;
        }

        if(addition == org){
            System.out.println("armstrong");
        }
        else {
            System.out.println("not armstrong " + addition);
        }
    }

    private void reverseNumber(int number){

        int rev = 0;

        while(number > 0){
            rev = rev * 10;
            rev = rev + number%10;
            number = number/10;
        }

        System.out.println(rev);
    }

    private double findSqrt(double number) {

        for(int i=1;i<number;i++){
            double expected = i * i;

            if(expected == number){
                return i;
            }
            else if(expected > number){
                return findSqrt(number, i-1, i);
            }
        }

        return Double.NaN;
    }

    private double findSqrt(double number, double low, double high) {

        double mid = (low + high) /2;

        double expected = mid * mid;

        System.out.println(low + " " + high + " " + mid + " " + expected);

        if(expected == number || Math.abs(number - expected) < 0.099){
            return mid;
        }
        else if(expected > number){
            return findSqrt(number,low,mid);
        }
        else if(expected < number){
            return findSqrt(number,mid,high);
        }

        return 0;
    }

    private String revStr(String str){

        if(str == null || str.isEmpty()){
            return str;
        }

        return str.charAt(str.length()-1) + revStr(str.substring(0,str.length()-1));
    }

    private boolean isLeapYear(int year){
        return year%400 == 0 || (year%100 != 0 && year%4 == 0);
    }

    private int factorial(int number) {

        if(number == 0){
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.findSqrt(12));
        System.out.println(sqrt.findSqrt(4));
        System.out.println(sqrt.findSqrt(13));
        sqrt.reverseNumber(145);
        sqrt.armstrong(153);
        sqrt.armstrong(159);
        System.out.println("rev str : " + sqrt.revStr("Palak"));
        System.out.println(sqrt.isLeapYear(2012));
        System.out.println(sqrt.isLeapYear(2014));
        System.out.println(sqrt.factorial(4));
    }
}
