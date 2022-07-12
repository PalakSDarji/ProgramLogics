package com.palak.collections;

import java.util.*;

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


        System.out.println("LinkedList starts -------------");
        /**
         *
         * LINKED LIST:
         *
         */
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.addFirst(0);
        linkedList.addLast(2);

        System.out.println(linkedList);//[0, 1, 2]

        linkedList.add(1,-1);
        System.out.println(linkedList);//[0, -1, 1, 2]
        linkedList.set(2,-2);
        System.out.println(linkedList);//[0, -1, -2, 2]

        linkedList.offer(3);
        System.out.println(linkedList);//[0, -1, -2, 2, 3]

        System.out.println(linkedList.get(3)); //2

        linkedList.push(-3); // push will add to front of linked list.
        System.out.println(linkedList);//[-3, 0, -1, -2, 2, 3]

        linkedList.pop(); //pop will remove from front.. stack like behavior.
        System.out.println(linkedList);//[0, -1, -2, 2, 3]

        Iterator desItr = linkedList.descendingIterator();//retrived from tail to head.
        while (desItr.hasNext()){
            System.out.print(desItr.next()+" ");
        }

        System.out.println();
        System.out.println("---");

        Spliterator<Integer> spliterators = linkedList.stream().spliterator();
        while (spliterators.tryAdvance(i-> System.out.print(i+" ")));

        System.out.println();
        System.out.println("---");
        Spliterator<Integer> sp1 = linkedList.spliterator();
        sp1.forEachRemaining(i->{
            System.out.println(" value from sp1 : "+i);
        });

        Spliterator<Integer> sp2 = sp1.trySplit();

        if(sp2 != null){
            sp2.forEachRemaining(i->{
                System.out.println(" value from sp2 : "+i);
            });
        }

    }
}
