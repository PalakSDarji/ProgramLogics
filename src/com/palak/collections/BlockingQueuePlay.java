package com.palak.collections;

import java.util.concurrent.*;

public class BlockingQueuePlay {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(2);//FIFO
        //LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>(2);//LIFO uses.. takeLast.

        Thread1 thread1 = new Thread1(arrayBlockingQueue);
        thread1.start();
        Thread2 thread2 = new Thread2(arrayBlockingQueue);
        thread2.start();

        thread1.join();
        thread2.join();

        BlockingDeque<Integer> linkedBlockingQueue = new LinkedBlockingDeque<>(2);
        thread1 = new Thread1(linkedBlockingQueue);
        thread1.start();
        thread2 = new Thread2(linkedBlockingQueue);
        thread2.start();

        thread1.join();
        thread2.join();

    }

    static class Thread1 extends Thread{
        BlockingQueue<Integer> arrayBlockingQueue;
        public Thread1(BlockingQueue<Integer> arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            for(int i=0;i<20;i++){
                try {
                    System.out.println("thread 1 putting "+ i);
                    arrayBlockingQueue.put(i);
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread2 extends Thread{
        BlockingQueue<Integer> arrayBlockingQueue;
        public Thread2(BlockingQueue<Integer> arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            for(int i=0;i<20;i++){
                try {
                    int v = arrayBlockingQueue.take();
                    System.out.println("thread 2 taking "+ v);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
