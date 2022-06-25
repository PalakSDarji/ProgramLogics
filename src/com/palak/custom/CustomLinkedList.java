package com.palak.custom;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public CustomLinkedList(T initial) {
        this.head = new Node<T>(initial);
        this.tail = head;
    }

    public void add(T data){
        add(new Node<T>(data));
    }

    public void add(Node<T> node){
        this.tail.setNextNode(node);
        this.tail = node;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(T data){
        setHead(new Node<T>(data));
    }

    private void setHead(Node<T> newHead) {
        newHead.setNextNode(this.head);
        this.head = newHead;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(T data){
        setTail(new Node<T>(data));
    }

    private void setTail(Node<T> newTail) {
        this.tail.setNextNode(newTail);
        this.tail = newTail;
    }

    public long length(){
        long len = 0;
        if(head != null){
            len = 1;
            Node<T> cur = head;
            while (cur.getNextNode() != null){
                len++;
                cur = cur.getNextNode();
            }
        }
        return len;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()){
            T data = itr.next();
            stringBuilder.append(data);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    public static class Node<T> {
        private T data;
        private Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }

    private class LinkedListIterator implements Iterator<T>{

        private Node<T> head;
        private Node<T> pre = null;
        private Node<T> current = null;

        public LinkedListIterator(Node<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            if(current == null){
                return head != null;
            }
            else {
                return current.getNextNode() != null;
            }
        }

        @Override
        public T next() {

            if(current == null){
                current = head;
                return current.getData();
            }
            else if(pre == null){
                pre = current;
                current = current.getNextNode();
                return current.getData();
            }
            else{
                pre = current;//To store prev relation. used while deleting.
                current = current.getNextNode();
                return current.getData();
            }

            /*pre = current;//To store prev relation. used while deleting.
            T data = current.getData();
            current = current.getNextNode();
            return data;*/
        }

        @Override
        public void remove() {
             pre.setNextNode(current.getNextNode());
             current = pre;
        }
    }
}
