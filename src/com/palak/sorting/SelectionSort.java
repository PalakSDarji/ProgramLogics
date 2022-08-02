package com.palak.sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 5,3,4,1
     * 3,5,4,1
     *
     * 1,3,4,5
     */
    private void sort(int[] arr){

        int currentSortedIndex = 0;
        for(int i=0; i< arr.length; i++){
            int min = arr[currentSortedIndex];
            int minIndex = currentSortedIndex;
            for(int j=currentSortedIndex; j< arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(arr[i] > min){
                int temp = arr[i];
                arr[i] = min;
                arr[minIndex] = temp;
            }
            currentSortedIndex++;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5,3,4,1};
        new SelectionSort().sort(arr);
    }
}
