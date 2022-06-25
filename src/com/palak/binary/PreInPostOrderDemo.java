package com.palak.binary;

import com.palak.custom.CustomBinaryTree;

public class PreInPostOrderDemo {
    public static void main(String[] args) {

        /**
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         */
        CustomBinaryTree<Integer> tree = BinaryTreeProvider.provide();

        tree.preOrder((node)->{
            System.out.println("Node data : " + node.getData());
        });
        System.out.println("------");
        tree.preOrderWithoutRecursion((node)->{
            System.out.println("Node data : " + node.getData());
        });
        System.out.println("------");
        tree.inOrder((node)->{
            System.out.println("Node data : " + node.getData());
        });
        System.out.println("------");
        tree.inOrderWithoutRecursion((node)->{
            System.out.println("Node data : " + node.getData());
        });
        System.out.println("------");
        tree.postOrder((node)->{
            System.out.println("Node data : " + node.getData());
        });
        System.out.println("------");
        tree.postOrderWithoutRecursion((node)->{
            System.out.println("Node data : " + node.getData());
        });
    }
}
