package com.palak;

public class SqrtRootManual {

    private double PRECISION = 0.0009;

    private double sqrt(double input){

        for(int i=1;i<=input;i++){
            int expected = i * i;

            if(expected == input){
                return i;
            }
            else if(expected > input){
                return sqrt(input,i-1,i);
            }
        }

        return Double.NaN;
    }

    private double sqrt(double input, double low, double high) {

        double mid = (low + high) / 2;
        double expected = mid * mid;
        //System.out.println(low + " " + high + " " + mid + " " + expected);
        if(expected == input || Math.abs(input - expected) < PRECISION){
            return mid;
        }
        else if(expected < input){
            return sqrt(input,mid,high);
        }
        else {
            return sqrt(input,low,mid);
        }

    }


    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            System.out.println("Sqrt of " + i +" : " + new SqrtRootManual().sqrt(i));
        }

    }
}
