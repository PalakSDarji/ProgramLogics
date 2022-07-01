package com.palak;

import com.palak.binary.BinaryTreeProvider;
import com.palak.custom.CustomBinaryTree;

import java.util.Stack;

public class Revision {

    //153 = 1^3 + 5^3 +3^3
    private void armstrong(int number){

        int addition = 0;
        int org = number;

        while(number > 0) {
            int rem = number%10;
            addition = addition + (rem * rem * rem);
            number = number/10;
        }

        if(addition == org){
            System.out.println("armstrong");
        }
        else {
            System.out.println("not armstrong " + addition);
        }
    }

    private void reverseNumber(int number){

        int rev = 0;

        while(number > 0){
            rev = rev * 10;
            rev = rev + number%10;
            number = number/10;
        }

        System.out.println(rev);
    }

    private double findSqrt(double number) {

        for(int i=1;i<number;i++){
            double expected = i * i;

            if(expected == number){
                return i;
            }
            else if(expected > number){
                return findSqrt(number, i-1, i);
            }
        }

        return Double.NaN;
    }

    private double findSqrt(double number, double low, double high) {

        double mid = (low + high) /2;

        double expected = mid * mid;

        System.out.println(low + " " + high + " " + mid + " " + expected);

        if(expected == number || Math.abs(number - expected) < 0.099){
            return mid;
        }
        else if(expected > number){
            return findSqrt(number,low,mid);
        }
        else if(expected < number){
            return findSqrt(number,mid,high);
        }

        return 0;
    }

    private String revStr(String str){

        if(str == null || str.isEmpty()){
            return str;
        }

        return str.charAt(str.length()-1) + revStr(str.substring(0,str.length()-1));
    }

    private boolean isLeapYear(int year){
        return year%400 == 0 || (year%100 != 0 && year%4 == 0);
    }

    private int factorial(int number) {

        if(number == 0){
            return 1;
        }

        return number * factorial(number - 1);
    }

    private void preOrderWR(){
        CustomBinaryTree<Integer> tree = BinaryTreeProvider.provide();
        Stack<CustomBinaryTree.TreeNode<Integer>> stack = new Stack<>();
        stack.push(tree.getRoot());

        while(!stack.isEmpty()){
            CustomBinaryTree.TreeNode<Integer> current = stack.pop();
            System.out.println("Current : " + current.getData());

            if(current.getRight() != null){
                stack.push(current.getRight());
            }

            if(current.getLeft() != null){
                stack.push(current.getLeft());
            }
        }
    }

    private void inOrderWR(){
        CustomBinaryTree<Integer> tree = BinaryTreeProvider.provide();
        Stack<CustomBinaryTree.TreeNode<Integer>> stack = new Stack<>();
        CustomBinaryTree.TreeNode<Integer> current = tree.getRoot();
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.getLeft();
            }
            else{
                CustomBinaryTree.TreeNode<Integer> node = stack.pop();
                System.out.println("Current: "+node.getData());
                current = node.getRight();
            }
        }
    }

    private void postOrderWR(){
        /**
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         */
        //1
        CustomBinaryTree<Integer> tree = BinaryTreeProvider.provide();
        Stack<CustomBinaryTree.TreeNode<Integer>> stack = new Stack<>();
        stack.push(tree.getRoot());

        while(!stack.isEmpty()){
            CustomBinaryTree.TreeNode<Integer> node = stack.peek();

            if(node.isLeaf()){
                CustomBinaryTree.TreeNode<Integer> cur = stack.pop();
                System.out.println("Current: "+cur.getData());
            }

            if(node.getRight() != null){
                stack.push(node.getRight());
                node.setRight(null);
            }

            if(node.getLeft() != null){
                stack.push(node.getLeft());
                node.setLeft(null);
            }
        }
    }

    public static void main(String[] args) {
        Revision revision = new Revision();
        System.out.println(revision.findSqrt(12));
        System.out.println(revision.findSqrt(4));
        System.out.println(revision.findSqrt(13));
        revision.reverseNumber(145);
        revision.armstrong(153);
        revision.armstrong(159);
        System.out.println("rev str : " + revision.revStr("Palak"));
        System.out.println(revision.isLeapYear(2012));
        System.out.println(revision.isLeapYear(2014));
        System.out.println(revision.factorial(4));
        System.out.println("-----");
        System.out.println("Preorder: ");
        revision.preOrderWR();
        System.out.println("-----");
        System.out.println("Inorder: ");
        revision.inOrderWR();
        System.out.println("-----");
        System.out.println("PostOrder: ");
        revision.postOrderWR();
    }
}
