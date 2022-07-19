package com.palak.java;

public class InnerPlay {

    private static int iStatic;
    private int i;

    private void doTest(){

        Inner2 inner2 = new Inner2();
        System.out.println(inner2.id);

        Inner2 inner21 = new Inner2(){
            @Override
            String changeId() {
                return "asd";
            }
        };

        System.out.println(inner21.changeId());
        System.out.println(inner21.doInnerTest());
    }

    public static void main(String[] args) {

        Inner1 inner1 = new Inner1();
        System.out.println(inner1.id);

        InnerPlay innerPlay = new InnerPlay();
        innerPlay.doTest();
    }

    static class Inner1 {
        String id;

        void doInnerStaticTest(){
            System.out.println(iStatic);
        }

        class NestedInner{

        }
    }

    class Inner2 {
        String id;

        String changeId(){
            return id;
        }

        int doInnerTest(){
            System.out.println(i);
            return i;
        }
    }
}
