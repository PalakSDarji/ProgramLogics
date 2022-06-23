package com.palak;

import java.util.Arrays;

public class ArrayReversalWithoutBuffer {

    private int[] reverseArray(int[] arr){
        for(int i=0;i<arr.length/2;i++) {

            int firstElement = arr[i];
            int lastElement = arr[arr.length-1-i];

            arr[arr.length-1-i] = firstElement;
            arr[i] = lastElement;
        }

        return arr;
    }

    private <T> T[] reverseGenericArr(T[] arr){
        for(int i=0;i<arr.length/2;i++){

            T temp = arr[i];
            T replacement = arr[arr.length-1-i];

            arr[i] = replacement;
            arr[arr.length-1-i] = temp;
        }

        return arr;
    }

    private void reverseString(String input){
        System.out.println(Arrays.toString(reverseGenericArr(input.split(" "))));
    }

    public static void main(String[] args) {
        ArrayReversalWithoutBuffer arrayReversalWithoutBuffer = new ArrayReversalWithoutBuffer();
        System.out.println(Arrays.toString(arrayReversalWithoutBuffer.reverseArray(new int[]{2,3,6})));

        arrayReversalWithoutBuffer.reverseString("Java is love for life");
    }
}
