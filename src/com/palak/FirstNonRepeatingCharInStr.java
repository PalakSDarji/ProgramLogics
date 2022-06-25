package com.palak;

import java.util.*;

public class FirstNonRepeatingCharInStr {

    private char firstNonRepeatingCharUsingSetAndList(String input){

        //hello
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();

        for(int i=0;i<input.length();i++){
            char letter = input.charAt(i);

            if(!set.contains(letter)){
                if(list.contains(letter)){
                    list.remove((Character) letter);
                    set.add(letter);
                }
                else{
                    list.add(letter);
                }
            }
        }

        return list.get(0);
    }

    private char findUsingLinkedHashMap(String input){

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(int i = 0; i<input.length(); i++){

            char c = input.charAt(i);
            int count = 0;
            if(map.containsKey(c)){
                count = map.get(c);
            }
            count++;
            map.put(c,count);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        FirstNonRepeatingCharInStr obj = new FirstNonRepeatingCharInStr();
        System.out.println(obj.findUsingLinkedHashMap("swiss"));
        System.out.println(obj.findUsingLinkedHashMap("hello"));

        //System.out.println(obj.firstNonRepeatingCharUsingSetAndList("swiss"));
        System.out.println(obj.firstNonRepeatingCharUsingSetAndList("helloh"));
    }
}
