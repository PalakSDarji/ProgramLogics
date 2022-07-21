package com.palak.java;

import com.palak.kolin.UserSingleton;

import java.util.Vector;

public class MemoryLeakPlay {
    public static void main(String[] args) {
        Vector v = new Vector(2144444444);
        Vector v1 = new Vector(214744444);
        Vector v2 = new Vector(214444444);
        System.out.println("Memory Leaks Example");
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space


        UserSingleton.getInstance();
    }
}
