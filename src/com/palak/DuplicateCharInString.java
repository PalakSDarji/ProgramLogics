package com.palak;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharInString {

    private final Map<Character,Integer> map = new HashMap<>();

    private void checkDuplicateCharsInStringAndPrint(String input){

        for(int i =0; i<input.length(); i++){
            char c = input.charAt(i);
            int count = 0;
            if(map.containsKey(c)){
                count = map.get(c);
            }
            map.put(c,++count);
        }

        System.out.println(map);
    }

    public static void main(String[] args) {

        new DuplicateCharInString().checkDuplicateCharsInStringAndPrint("Java Palak");
    }
}
