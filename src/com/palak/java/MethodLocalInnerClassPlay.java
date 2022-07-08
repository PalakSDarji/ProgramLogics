package com.palak.java;

public class MethodLocalInnerClassPlay {
    public static void main(String[] args) {

        String data = "Sample";

        /**
         * - Local classes are limited to containing block.
         * - Local classes can not be public,private,default,protected.
         * - Local classes can access containing classes instance variable, method
         * params.
         * - Local classes can not be static.
         * - Local classes can not have static methods.
         *
         */
        class InnerClass{
            static final int i=0;
            void print(){
                System.out.println(data+ i);
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }
}
