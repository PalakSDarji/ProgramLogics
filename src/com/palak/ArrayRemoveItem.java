package com.palak;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRemoveItem {

    private int[] removeIndex(int[] arr, int index){

        if(arr == null || index < 0 || index > arr.length){
            return arr;
        }

        int[] anotherArr = new int[arr.length-1];

        for(int i=0,k=0; i< arr.length;i++){

            if(i == index) continue;

            anotherArr[k] = arr[i];
            k++;
        }

        return anotherArr;
    }

    private int[] removeItemFromArrayUsingArrayList(int[] arr, int index){

        List<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toList());

        al.remove(index);

        return al.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int no = 2;
        int[] arr = new int[no];
        arr[0]=1;
        arr[1]=2;

        System.out.println(Arrays.toString(arr));

        ArrayRemoveItem arrayRemoveItem = new ArrayRemoveItem();
        int[] arrNew = arrayRemoveItem.removeIndex(arr,1);
        System.out.println(Arrays.toString(arrNew));
    }
}
