package com.palak.sorting;

import java.util.Arrays;

//This is bubble sort.
//O(n^2)
public class BubbleSort {

    private void doBubbleSort(int[] arr){

        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.doBubbleSort(new int[]{64, 34, 25, 12, 22, 11, 90});
    }
}
