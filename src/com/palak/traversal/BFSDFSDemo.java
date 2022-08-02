package com.palak.traversal;

import com.palak.binary.BinaryTreeProvider;
import com.palak.custom.CustomBinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class BFSDFSDemo {

    ArrayDeque<CustomBinaryTree.TreeNode<Integer>> arrayDeque = new ArrayDeque();
    /**
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     */
    private void dfs(CustomBinaryTree.TreeNode<Integer> node){

        arrayDeque.push(node);

        while(!arrayDeque.isEmpty()){
            CustomBinaryTree.TreeNode<Integer> current = arrayDeque.pop();
            if (current != null){
                System.out.println("Visiting : "+ current.getData());
                if(current.getRight() != null) arrayDeque.push(current.getRight());
                if(current.getLeft() != null) arrayDeque.push(current.getLeft());
            }
        }
        /**
         * Visiting : 3
         * Visiting : 4
         * Visiting : 2
         * Visiting : 6
         * Visiting : 5
         * Visiting : 1
          */
    }

    private void dfsRec(CustomBinaryTree.TreeNode<Integer> node){

        arrayDeque.push(node);

        while(!arrayDeque.isEmpty()){
            CustomBinaryTree.TreeNode<Integer> current = arrayDeque.pop();
            if (current != null){
                System.out.println("Visiting : "+ current.getData());
                if(current.getLeft() != null) dfsRec(current.getLeft());
                if(current.getRight() != null) dfsRec(current.getRight());
            }
        }
        /**
         * Visiting : 3
         * Visiting : 4
         * Visiting : 2
         * Visiting : 6
         * Visiting : 5
         * Visiting : 1
         */
    }

    LinkedList<CustomBinaryTree.TreeNode<Integer>> linkedList = new LinkedList<>();

    private void bfs(CustomBinaryTree.TreeNode<Integer> node){

        linkedList.addLast(node);

        while (!linkedList.isEmpty()){
            CustomBinaryTree.TreeNode<Integer> current = linkedList.pollFirst();
            System.out.println("Visiting:  "+ current.getData());
            if(current.getLeft() != null) linkedList.addLast(current.getLeft());
            if(current.getRight() != null) linkedList.addLast(current.getRight());
        }
        /**
         * Visiting:  1
         * Visiting:  2
         * Visiting:  5
         * Visiting:  3
         * Visiting:  4
         * Visiting:  6
         */
    }

    public static void main(String[] args) {
        BFSDFSDemo dfsDemo = new BFSDFSDemo();

        CustomBinaryTree<Integer> customBinaryTree = BinaryTreeProvider.provide();

        System.out.println("------DFS:");
        dfsDemo.dfs(customBinaryTree.getRoot());

        System.out.println("------DFS using recursion:");
        dfsDemo.dfsRec(customBinaryTree.getRoot());

        System.out.println("------BFS:");
        dfsDemo.bfs(customBinaryTree.getRoot());
    }
}
