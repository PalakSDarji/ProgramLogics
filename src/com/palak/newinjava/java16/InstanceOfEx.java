package com.palak.newinjava.java16;

public class InstanceOfEx {
    public static void main(String[] args) {
        Object obj = "asd";
        if(obj instanceof String str){
            System.out.println(str.toString());
        }
    }
}
