package com.palak.binary;

import com.palak.custom.CustomBinaryTree;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class FindLeafInBinaryTree {

    /**
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * 3 4 6
     */
    public void printLeaves(CustomBinaryTree<Integer> tree) {

        //Use any traversal algo, but check while poping/visiting node, whether they are leaf node.
        //Here I have used in-order traversal iterative approach.

        Stack<CustomBinaryTree.TreeNode<Integer>> stack = new Stack<>();
        CustomBinaryTree.TreeNode<Integer> current = tree.getRoot();

        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.getLeft();
            }
            else {
                CustomBinaryTree.TreeNode<Integer> node = stack.pop();
                if(node.getRight() == null && node.getLeft() == null){
                    System.out.println("Node: "+ node.getData());
                }
                current = node.getRight();
            }
        }
    }

    public void printLeavesRecursively(CustomBinaryTree<Integer> tree){
        printLeavesRecursively(tree.getRoot());
    }

    //Here I have pre-order traversal using recursion.
    private void printLeavesRecursively(CustomBinaryTree.TreeNode<Integer> node) {
        if(node == null) return;

        if(node.getLeft() == null && node.getRight() == null) {
            System.out.println("Node: "+ node.getData());
        }

        printLeavesRecursively(node.getLeft());
        printLeavesRecursively(node.getRight());
    }

    public static void main(String[] args) {

        FindLeafInBinaryTree findLeafInBinaryTree = new FindLeafInBinaryTree();
        CustomBinaryTree<Integer> tree = BinaryTreeProvider.provide();
        findLeafInBinaryTree.printLeaves(tree);
        findLeafInBinaryTree.printLeavesRecursively(tree);
    }
}
