package com.palak;

import java.util.HashMap;
import java.util.Map;

public class StringAnagram {

    private void checkIfStrIsAnagram(String input, String anagram){

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            int count = 0;
            if(map.containsKey(c)){
                count = map.get(c);
            }
            count++;
            map.put(c,count);
        }

        for(int i=0;i<anagram.length();i++){
            char c = anagram.charAt(i);
            int count = 0;
            if(map.containsKey(c)){
                count = map.get(c);
            }
            if(count == 1){
                map.remove(c);
            }
            else{
                count--;
                map.put(c,count);
            }
        }
        if(map.size() == 0) {
            System.out.println("is Anagram");
        }
        else {
            System.out.println("is not Anagram");
        }
    }

    //Better approach.
    private boolean checkAnagram(String first, String second){

        if(first.length() != second.length()){
            return false;
        }

        char[] charArr = first.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(second);

        for(char c : charArr){
            int index = stringBuilder.indexOf(""+c);
            if(index != -1){
                stringBuilder.deleteCharAt(index);
            }
        }

        return stringBuilder.length() == 0;
    }

    public static void main(String[] args) {

        StringAnagram stringAnagram = new StringAnagram();
        stringAnagram.checkIfStrIsAnagram("Palawk","kPaal");
        System.out.println(stringAnagram.checkAnagram("Palawk","kPaal"));
        System.out.println(stringAnagram.checkAnagram("mary", "army"));
    }
}
