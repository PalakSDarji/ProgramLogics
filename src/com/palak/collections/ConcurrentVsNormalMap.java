package com.palak.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConcurrentVsNormalMap {
    public static void main(String[] args) throws InterruptedException {

        Set<Integer> set = new LinkedHashSet<>();

        //putting hashMap to this test will result in some kind of failure. either concurrentModification somewhere,
        //or value changed will not match the value stored.
        //HashMap<Integer,String> map = new HashMap<>();

        //ConcurrentHashMap's will work just fine. everytime.
        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();

        AdderThread adderThread = new AdderThread(map);
        adderThread.start();

        ChangerThread changerThread = new ChangerThread(map,set);
        changerThread.start();

        adderThread.join();
        changerThread.join();

        System.out.println("Now check.");

        //Now check the result.
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            if(set.contains(entry.getKey())){
                //if set has the key, which means its modifiable.
                if(entry.getValue().equals(entry.getKey().toString()+entry.getKey())){
                    //Matched. Ignore.. don't print.
                    continue;
                }
                else{
                    System.out.println("not matched from set: "+ entry.getKey() +" with " + entry.getValue());
                }
            }
            else{
                if(entry.getValue().equals(entry.getKey().toString())){
                    //Matched. Ignore.. don't print.
                    continue;
                }
                else{
                    System.out.println("not matched : "+ entry.getKey() +" with " + entry.getValue());
                }
            }
        }
        System.out.println(map); //print to check all the content.
    }

    static class AdderThread extends Thread{

        private final Map<Integer,String> map;

        public AdderThread(Map<Integer, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                map.put(i,""+i);
                System.out.println(i);
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ChangerThread extends Thread{

        private final Map<Integer,String> map;
        private final Set<Integer> set;
        private final ThreadLocal<Random> randomThreadLocal = ThreadLocal.withInitial(new Supplier<Random>() {
            @Override
            public Random get() {
                return new Random();
            }
        });

        public ChangerThread(Map<Integer, String> map,Set<Integer> set) {
            this.map = map;
            this.set = set;
        }

        private int getUniqueRandomIndex(){
            int randomIndex = randomThreadLocal.get().nextInt(1000);
            if(!set.contains(randomIndex)){
                return randomIndex;
            }
            return getUniqueRandomIndex();
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++){

               int randomIndex = getUniqueRandomIndex();

                map.computeIfPresent(randomIndex, new BiFunction<>() {
                    @Override
                    public String apply(Integer key, String value) {
                        //if index found, then we store this index on set.
                        set.add(key);
                        return value + value;
                    }
                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
