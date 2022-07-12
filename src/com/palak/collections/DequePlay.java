package com.palak.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequePlay {
    public static void main(String[] args) {

        Deque<Integer> arrayDeque = new ArrayDeque<>(3);//This is not max capacity, but initial capacity.

        /**
         * Add, Offer, Push.
         */
        arrayDeque.offer(1);//offerFirst will add to head, offerLast will add to tail.
        arrayDeque.offer(2);
        arrayDeque.add(3);//addFirst will add to head, addLast will add to tail.
        arrayDeque.add(4);//won't break. it will expand its capacity.
        System.out.println(arrayDeque);//[1, 2, 3, 4]

        arrayDeque.addFirst(0);
        System.out.println(arrayDeque);//[0, 1, 2, 3, 4]

        arrayDeque.addLast(5);
        System.out.println(arrayDeque);//[0, 1, 2, 3, 4, 5]

        /**
         * Element, get, peek.
         */

        System.out.println(arrayDeque.element());//fetch head without removal. There is not elementFirst, elementLast methods for deque.
        //instead use getFirst, getLast (they throw exceptions when empty). output 0

        System.out.println(arrayDeque.getFirst());//0
        System.out.println(arrayDeque.getLast());//5

        System.out.println(arrayDeque.peek());//0
        System.out.println(arrayDeque.peekFirst());//0
        System.out.println(arrayDeque.peekLast());//5

        /**
         * Poll, remove, Pop.
         */
        System.out.println(arrayDeque.remove());//removed 0. exception if empty.
        System.out.println(arrayDeque);//[1, 2, 3, 4, 5]

        System.out.println(arrayDeque.removeLast());//removed 5 and returned.  exception if empty.
        System.out.println(arrayDeque);//[1, 2, 3, 4]

        System.out.println(arrayDeque.poll());//removed 1
        System.out.println(arrayDeque);//[2, 3, 4]

        arrayDeque.push(-1);//added to head of the queue. which means start/front.
        System.out.println(arrayDeque);//[-1, 2, 3, 4]

        arrayDeque.pop();//remove and returned -1.
        System.out.println(arrayDeque);//[2, 3, 4]

    }
}
