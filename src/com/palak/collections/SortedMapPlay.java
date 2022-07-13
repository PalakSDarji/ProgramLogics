package com.palak.collections;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapPlay {
    public static void main(String[] args) {

        //SortedMap
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(3,"3");
        sortedMap.put(5,"5");
        sortedMap.put(2,"2");
        sortedMap.put(0,"0");
        //sortedMap.put(null,"3");//allowed on compile time, but will throw null pointer on runtime on this line.
        System.out.println(sortedMap);//{0=0, 2=2, 3=3, 5=5}

        System.out.println(sortedMap.headMap(4));//{0=0, 2=2, 3=3}
        System.out.println(sortedMap.tailMap(4));//{5=5}

        System.out.println(sortedMap.subMap(2,5));//{2=2, 3=3}

        System.out.println(sortedMap.firstKey());//0
        System.out.println(sortedMap.lastKey());//5

        sortedMap = new TreeMap<>((o1, o2) -> {
            return o2.compareTo(o1);//reversed. descending
        });
        sortedMap = new TreeMap<>(Comparator.reverseOrder());//this works as well.descending
        sortedMap.put(3,"3");
        sortedMap.put(5,"5");
        sortedMap.put(2,"2");
        sortedMap.put(0,"0");

        System.out.println(sortedMap);//{5=5, 3=3, 2=2, 0=0}

        //NavigableMap
        NavigableMap<Integer,String> navigableMap = new TreeMap<>();
        navigableMap.put(3,"3");
        navigableMap.put(5,"5");
        navigableMap.put(2,"2");
        navigableMap.put(0,"0");

        System.out.println(navigableMap.ceilingKey(4));//5
        System.out.println(navigableMap.floorEntry(4));//3=3
        System.out.println(navigableMap.higherKey(2));//3
        System.out.println(navigableMap.lowerKey(2));//0
    }
}
