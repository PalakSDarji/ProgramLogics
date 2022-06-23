package com.palak;

public class BinarySearch {

    private int search(int[] arr, int searchInt) {
        return binarySearch(arr,searchInt, 0,arr.length-1);
    }

    private int binarySearch(int[] inputArr, int searchInt, int low, int high) {

        int mid = (low + high) /2;

        if(inputArr[mid] == searchInt){
            return mid;
        }
        if(inputArr[mid+1] == searchInt){
            return mid+1;
        }
        else if(inputArr[mid] < searchInt){
            return binarySearch(inputArr,searchInt,mid,high);
        }
        else if(inputArr[mid] > searchInt){
            return binarySearch(inputArr,searchInt,low,mid);
        }

        return -1;
    }

    private int binarySearchBetterApproach(int[] inputArr, int searchInt){

        int low = 0;
        int high = inputArr.length - 1;

        while(high >= low){
            int mid = (low + high) /2;
            if(inputArr[mid] == searchInt){
                return mid;
            }
            else if(inputArr[mid] < searchInt){
                low = mid + 1;
            }
            else if(inputArr[mid] > searchInt){
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,5,7,8,10};

        BinarySearch binarySearch = new BinarySearch();
        System.out.println("10 is of index: " + binarySearch.search(arr,10));
        System.out.println("5 is of index: " + binarySearch.binarySearchBetterApproach(arr,5));
    }

}
