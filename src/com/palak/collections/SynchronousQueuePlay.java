package com.palak.collections;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousQueuePlay {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();

        Thread1 thread1 = new Thread1(synchronousQueue);
        thread1.start();

        Thread2 thread2 = new Thread2(synchronousQueue);
        thread2.start();

        thread1.join();
        thread2.join();
    }

    static class Thread1 extends Thread {
        private final SynchronousQueue<String> synchronousQueue;
        private final AtomicInteger counter = new AtomicInteger(0);

        public Thread1(SynchronousQueue<String> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {
            try {
                while(counter.get() < 10){
                    int value = counter.incrementAndGet();
                    synchronousQueue.put(""+value);
                    System.out.println("value put : "+ value);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread2 extends Thread {
        private final SynchronousQueue<String> synchronousQueue;

        public Thread2(SynchronousQueue<String> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {
            try {
                while (true){
                    String val = synchronousQueue.take();
                    if(val == null){
                        break;
                    }
                    else{
                        System.out.println("value taken : "+ val);
                    }
                    Thread.sleep(3000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
