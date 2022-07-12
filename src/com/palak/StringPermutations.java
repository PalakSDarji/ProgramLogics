package com.palak;

import java.util.*;

public class StringPermutations {

    //WRONG. NOT WORKING.
    private void printPermutations(String input){

        //AB - BA
        //ABC - BAC,  BCA, CBA, ACB,

        Set<String> set = new LinkedHashSet<>();
        char[] charArr;
        for(int i=0;i<input.length();i++){
            for(int j=0;j<input.length();j++){

                charArr = input.toCharArray();
                if(i != j){
                    char temp = charArr[j];
                    charArr[j] = charArr[i];
                    charArr[i] = temp;
                    set.add(new String(charArr));
                }
            }
        }

        System.out.println(Arrays.toString(set.toArray()));
    }

    public static void main(String[] args) {
        StringPermutations stringPermutations = new StringPermutations();
        stringPermutations.printPermutations("ABC");
    }
}
