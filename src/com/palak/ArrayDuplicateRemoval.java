package com.palak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class ArrayDuplicateRemoval {

    private <T> T[] removeDuplicates(T[] arr){

        List<T> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }

        return (T[]) list.toArray();
    }

    private <T> T[] removeDuplicatesUsingCollections(T[] arr){
        return (T[]) new LinkedHashSet<>(Arrays.asList(arr)).toArray();
    }

    public static void main(String[] args) {

        ArrayDuplicateRemoval arrayDuplicateRemoval = new ArrayDuplicateRemoval();

        Integer[] intArr = {2,3,9,3,5,6,3,2};
        Object[] intResult = arrayDuplicateRemoval.removeDuplicates(intArr);
        System.out.println(Arrays.toString(intResult));

        String[] strArr = {"Pa","la","Pa","lak"};
        Object[] strResult = arrayDuplicateRemoval.removeDuplicates(strArr);
        System.out.println(Arrays.toString(strResult));

        Object[] intResult1 = arrayDuplicateRemoval.removeDuplicatesUsingCollections(intArr);
        System.out.println(Arrays.toString(intResult1));

        Object[] strResult1 = arrayDuplicateRemoval.removeDuplicatesUsingCollections(strArr);
        System.out.println(Arrays.toString(strResult1));
    }
}
