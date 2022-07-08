package com.palak.java;

import java.util.HashMap;
import java.util.Map;

public class ObjectEqualityPlay {
    public static void main(String[] args) {

        Person palak = new Person("palak");
        Person palakCopy = palak;
        Person dhara = new Person("dhara");

        System.out.println(palak == palakCopy);//true
        System.out.println(palak.equals(palakCopy));//true

        palak.name = "palak changed";

        System.out.println(palak == palakCopy);//true
        System.out.println(palak.equals(palakCopy));//true

        System.out.println(palak == dhara);//false
        System.out.println(palak.equals(dhara));//false

        dhara.name = "palak changed";

        System.out.println(palak == dhara);//false
        System.out.println(palak.equals(dhara));//false

        Person p1 = new Person("P");
        Person p2 = new Person("P");

        System.out.println(p1 == p2);//false
        System.out.println(p1.equals(p2)); //false as equals is not
        // overridden to match the content. by default, it will check for reference just like == operator.

        Map<String,String> sampleMap = new HashMap<>();
        System.out.println(sampleMap.get("P"));//returns null as we haven't put it yet.

        //String equality
        String s1 = new String("S");
        String s2 = new String("S");

        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true

        String s3 = "S";
        String s4 = "S";

        System.out.println(s3 == s4);//true
        System.out.println(s3.equals(s4));//true

        System.out.println(s1 == s3);//false
        System.out.println(s1.equals(s3));//true

        System.out.println(s1.intern() == s3);//true
        System.out.println(s1 == s3);//false

        ImmutableObj immutableObj = new ImmutableObj("final immutable class");
        immutableObj = new ImmutableObj("asd");// we can change the object ref but can't change the object content.

    }
}

final class ImmutableObj {
    final String data;

    public ImmutableObj(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
