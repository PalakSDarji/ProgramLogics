package com.palak.collections;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionPlay {
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        list.removeIf(o -> {
            if (o == 2){
                return true;
            }
            return false;
        });
        System.out.println(list);


        Spliterator<Integer> spliterators = list.spliterator();

        while(spliterators.tryAdvance((i)-> System.out.println("using tryAdvance"+i)));

        spliterators.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        Queue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);// Will not effect in any way.
        queue.offer(5);// Will not effect in any way.
        //queue.add(6); will throw IllegalStateException: Queue full.

        System.out.println(queue);//[1,2,3]

        queue.poll();//removes and return 1
        System.out.println(queue);//[2,3]

        Integer integer = queue.peek();//will return head.. won't remove.
        System.out.println(integer);//2
        System.out.println(queue);//[2,3]


        Queue<Integer> priorityQ = new PriorityQueue<>(2);
        priorityQ.offer(3);
        priorityQ.offer(1);
        priorityQ.offer(2);
        System.out.println(priorityQ);

    }
}
