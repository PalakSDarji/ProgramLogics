package com.palak.collections;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class SetPlay {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        set.add("AS");
        System.out.println(set);//[null, AS]


        EnumSet<DAYS> enumSet = EnumSet.allOf(DAYS.class);

        enumSet.add(DAYS.MONDAY);
        System.out.println(enumSet);//[SUNDAY, MONDAY]

        
    }
}