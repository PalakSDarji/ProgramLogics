package com.palak;

public class FindNextHighestNumber {
    public static void main(String[] args) {

        int[] arr1 = new int[]{ 1, 2, 3, -3,-6,7, 4, 11, 12, 31, 32};

        FindNextHighestNumber findNextHighestNumber = new FindNextHighestNumber();
        findNextHighestNumber.find(arr1);
    }

    private void find(int[] arr) {
        int highest = Integer.MIN_VALUE;
        int secondHighest =  Integer.MIN_VALUE;

        for(int number : arr){
            if(number > highest) {
                if(highest != Integer.MIN_VALUE){
                    secondHighest = highest;
                }
                highest = number;
            }
        }

        System.out.println("highest : " + highest);
        System.out.println("secondHighest : " + secondHighest);
    }
}
