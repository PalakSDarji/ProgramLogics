package com.palak;

/**
 * Armstrong number is 157 which is equal to 1^3 + 5^3 + 7^3.
 */

public class ArmstrongNumber {

    private boolean getArmstrongNumber(int input){

        int number = input;
        int addition = 0;

        while(number > 0){
            int rem = number % 10;
            addition = addition + (rem * rem * rem);
            number = number/ 10;
        }

        if(input == addition){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        for(int i = 0; i < 500 ; i++){
            if(armstrongNumber.getArmstrongNumber(i)){
                System.out.print(i + " ");
            }
        }

    }
}
