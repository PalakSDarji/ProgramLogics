package com.palak.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemos {

    private void removeDuplicatesFromArrayList(List<Integer> list){

        Set<Integer> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);

        System.out.println(list);
    }

    private void reverseArrayList(List<Integer> list){
        for(int i=0;i<list.size()/2;i++){
            int temp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,temp);
        }
        System.out.println(list);
    }

    private void synchronizedArrayList(List<Integer> list){

        List<Integer> syList = Collections.synchronizedList(list);
        syList.add(0);
        //use normally.. get/set all the methods are synchronized by synchronized block over object mutex.

        //NOTE: while using iterator.. use synchronized(syList) manually.

        //Two alternatives : Vector (old and threadsafe but slow), CopyOnWriteArrayList (concurrent)
        List<Integer> cwList = new CopyOnWriteArrayList<Integer>(list);
        //use above cw while having more reads and less writes.


        List<String> strList = Arrays.asList("w","2","-12","2.4","4","E");
        //strList.add("0"); //UnsupportedOperationException

        List<Integer> unmList = Collections.unmodifiableList(list);
        //unmList.add(3); //UnsupportedOperationException

        Collections.sort(list);
        System.out.println(list);

        //Collections.sort(strList); //[-12, 2, 2.4, 4, E, w]
        //System.out.println(strList);

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(strList);

        System.out.println(String.join(",", strList));
    }

    private void removeFromCopyOnWriteAL(){
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i=0;i<10;i++){
            copyOnWriteArrayList.add(i);
        }

        /*int length = copyOnWriteArrayList.size();
        for(int i=0;i<length;i++){
            if(copyOnWriteArrayList.get(i) == 2){
                copyOnWriteArrayList.remove(i);
                length--;
            }
        }*/

        /*Iterator<Integer> itr = copyOnWriteArrayList.iterator();
        while(itr.hasNext()){
            int i = itr.next();
            if(i%2==0){
                itr.remove();
            }
        }
        */
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            integers.remove(a);
        }
        System.out.println(integers);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(1);

        ArrayListDemos arrayListDemos = new ArrayListDemos();
        arrayListDemos.removeDuplicatesFromArrayList(list);
        list.add(13);
        arrayListDemos.reverseArrayList(list);
        arrayListDemos.synchronizedArrayList(list);
        arrayListDemos.removeFromCopyOnWriteAL();
    }
}
