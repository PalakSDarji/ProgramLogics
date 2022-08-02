package com.palak.binary;

import com.palak.custom.CustomBinaryTree;

public class BinaryTreeProvider {
    public static CustomBinaryTree<Integer> provide(){

        /**
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         */
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<Integer>();

        CustomBinaryTree.TreeNode<Integer> root = new CustomBinaryTree.TreeNode<Integer>(1);
        tree.setRoot(root);
        CustomBinaryTree.TreeNode<Integer> two = new CustomBinaryTree.TreeNode<>(2);
        CustomBinaryTree.TreeNode<Integer> five = new CustomBinaryTree.TreeNode<>(5);

        root.setLeft(two);
        root.setRight(five);

        two.setLeft(new CustomBinaryTree.TreeNode<>(3));
        two.setRight(new CustomBinaryTree.TreeNode<>(4));

        five.setRight(new CustomBinaryTree.TreeNode<>(6));

        return tree;
    }
}
