package com.palak;

import java.util.Arrays;

public class ArrayReversalWithoutBuffer {

    private int[] reverseArray(int[] arr){
        for(int i=0;i<arr.length/2;i++) {

            if(i == arr.length-1){
                break;
            }

            int firstElement = arr[i];
            int lastElement = arr[arr.length-1-i];

            arr[arr.length-1-i] = firstElement;
            arr[i] = lastElement;
        }

        return arr;
    }

    public static void main(String[] args) {
        ArrayReversalWithoutBuffer arrayReversalWithoutBuffer = new ArrayReversalWithoutBuffer();
        System.out.println(Arrays.toString(arrayReversalWithoutBuffer.reverseArray(new int[]{2,3,6})));
    }
}
