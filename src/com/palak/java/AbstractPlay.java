package com.palak.java;

abstract class AbstractSuper{
    AbstractSuper(){
        method1();
    }

    abstract void method1();
}

public class AbstractPlay extends AbstractSuper{

    String s = "a";

    @Override
    void method1() {
        System.out.println(s);
    }

    public static void main(String[] args) {

        AbstractPlay abstractPlay = new AbstractPlay();
        //abstractPlay.method1();

    }

}
