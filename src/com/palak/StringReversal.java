package com.palak;

public class StringReversal {

    private String reverse(String input){

        String rev = "";

        for(int i=input.length()-1 ; i>=0 ; i--){
            rev = rev + input.charAt(i);
        }

        return rev;
    }

    public static void main(String[] args) {
        StringReversal stringReversal = new StringReversal();
        System.out.println(stringReversal.reverse("Palak"));
    }
}
