package com.palak.collections;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArrayDequeOverStack {
    public static void main(String[] args) {

        //can't handle stack in list type. it extends vector which implements list interface.
        //List<Integer> stack = new Stack<>();
        //That is why ArrayDeque is preferred over stack. it can be handled with queue interface. part of collections.

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.get(0));//getting by index is against rule for stack type data structure.

        System.out.println(stack.pop());//remove and return.

        System.out.println(stack.peek());//only return.. dont remove.

        Queue<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);

        Child c = new Child();
        c.callC();
        c.callP();
    }
}

class Parent{
    void callP(){

    }
}

class Child extends Parent{
    void callC(){

    }
}