package com.palak.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InsertionSort {

    private void sort(int[] arr){

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        //3,5,2,6,4,1
        //1,2,3,5,6,4
        //12, 11, 13, 5, 6
        for(int i=0;i<list.size();i++){

            int delimiter = list.get(i);

            for(int j=0;j<i;j++){

                int sortedCur = list.get(j);

                if(sortedCur > delimiter){
                    list.remove(i);
                    list.add(j,delimiter);
                    break;
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {

        new InsertionSort().sort(new int[]{3,5,2,6,4,1});
    }
}
