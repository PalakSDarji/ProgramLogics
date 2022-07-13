package com.palak.collections;

import java.util.*;
import java.util.function.BiFunction;

public class MapPlay {
    public static void main(String[] args) throws InterruptedException {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(1,1);
        map.putIfAbsent(2,2);

        Map<Integer,Integer> newMap = new HashMap<>();
        newMap.put(3,3);
        map.putAll(newMap);

        System.out.println(map);//{1=1, 2=2, 3=3}

        newMap.put(4,4);//won't take any effect on map. since putAll copied once before this line. no ref.
        System.out.println(map);//{1=1, 2=2, 3=3}

        map.merge(3, 3, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer oldValue, Integer newValue) {
                return oldValue + newValue; //here if the key 3 is already present, then we will end up here to
                //manipulate the new value. We will simply make addition and store.
            }
        });

        System.out.println(map);//{1=1, 2=2, 3=6}

        map.merge(4,4, (oldValue, newValue)-> oldValue+newValue);//this won't call this addition function.
        //since there is no 4 key already exist in map.
        System.out.println(map);//{1=1, 2=2, 3=6, 4=4}

        map.remove(3);
        System.out.println(map);

        Integer five = 5;
        map.put(five, 5);
        System.out.println(map);//{1=1, 2=2, 4=4, 5=5} added five.

        five = null;//making the key point to null to see if hashMap's key value is garbage collected or not.
        System.gc();//calling gc.
        Thread.sleep(3000);//Waiting..
        System.out.println(map);//1=1, 2=2, 4=4, 5=5}//No, HashMap don't remove null keys and its associated values.

        //WeakHashMap.. lets try the same scenario.
        WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<>();
        Integer newFive = 5;
        weakHashMap.put(newFive, 5);
        newFive = null;
        System.gc();
        Thread.sleep(6000);
        System.out.println(weakHashMap);//Although this still prints {5=5} can't guarantee.


        //LinkedHashMap maintains insertion order because it uses linked list internally.
        //while HashMap uses Array internally.
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i=0;i<100;i++){
            linkedHashMap.put(i,i);
        }
        System.out.println(linkedHashMap);

        //EnumMap
        EnumMap<DAYS,String> enumMap = new EnumMap<DAYS, String>(DAYS.class);
        enumMap.put(DAYS.MONDAY,"monday");

        for(Map.Entry<DAYS,String> entry : enumMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

enum DAYS {
    SUNDAY,MONDAY
}