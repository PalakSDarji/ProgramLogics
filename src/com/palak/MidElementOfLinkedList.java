package com.palak;


import com.palak.custom.CustomLinkedList;

import java.util.Iterator;

public class MidElementOfLinkedList {

    private void trial(CustomLinkedList<Integer> linkedList){

        linkedList.setHead(0);
        System.out.println("linkedList : " + linkedList);

        Iterator<Integer> itr = linkedList.iterator();
        while(itr.hasNext()){
            int i = itr.next();
            if(i == 7){
                itr.remove();
                System.out.println("deleting 7");
            }
        }

        System.out.println("length again : " + linkedList.length());

        System.out.println("linkedList : " + linkedList);

    }

    private void find(CustomLinkedList<Integer> linkedList){

        CustomLinkedList.Node<Integer> head = linkedList.getHead();
        CustomLinkedList.Node<Integer> current = head;
        CustomLinkedList.Node<Integer> middle = head;
        int length = 1;

        while(current.getNextNode() != null){
            CustomLinkedList.Node<Integer> nextNode = current.getNextNode();
            length++;

            if(length % 2 == 1){
                middle = middle.getNextNode();
            }

            current = nextNode;
        }

        System.out.println("length: " + length);
        System.out.println("middle ele : " + middle.getData());

    }

    public static void main(String[] args) {

        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);

        MidElementOfLinkedList midElementOfLinkedList = new MidElementOfLinkedList();
        midElementOfLinkedList.find(linkedList);
        System.out.println("-------------");
        midElementOfLinkedList.trial(linkedList);
    }
}
