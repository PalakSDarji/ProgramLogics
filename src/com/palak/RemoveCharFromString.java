package com.palak;

public class RemoveCharFromString {

    private void removeCharFromString(String str, char removeThis){

        StringBuilder output = new StringBuilder();
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (removeThis == c) {
                continue;
            }
            output.append(c);
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        RemoveCharFromString removeCharFromString = new RemoveCharFromString();
        removeCharFromString.removeCharFromString("Palak",'a');
    }
}
