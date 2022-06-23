package com.palak;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        Set<Map.Entry<Character,Integer>> set = map.entrySet();

        for(Map.Entry<Character,Integer> entry : set){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {

        new DuplicateCharInString().checkDuplicateCharsInStringAndPrint("Java Palak Program");
    }
}
