package com.palak.custom;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class CustomBinaryTree<T> {

    private TreeNode<T> root;

    public void preOrder(Visitable<T> visitable){
        preOrder(root,visitable);
    }

    private void preOrder(TreeNode<T> node, Visitable<T> visitable){
        if(node == null) return;

        visitable.visit(node);
        preOrder(node.left,visitable);
        preOrder(node.right,visitable);
    }

    public void preOrderWithoutRecursion(Visitable<T> visitable) {
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode<T> current = stack.pop();
            visitable.visit(current);

            if(current.getRight() != null){
                stack.push(current.getRight());
            }
            if(current.getLeft() != null){
                stack.push(current.getLeft());
            }
        }
    }

    public void inOrder(Visitable<T> visitable){
        inOrder(root,visitable);
    }

    private void inOrder(TreeNode<T> node, Visitable<T> visitable) {
        if(node == null) return;

        inOrder(node.getLeft(),visitable);
        visitable.visit(node);
        inOrder(node.getRight(),visitable);
    }

    public void inOrderWithoutRecursion(Visitable<T> visitable){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root;

        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.getLeft();
            }
            else {
                TreeNode<T> node = stack.pop();
                visitable.visit(node);
                current = node.getRight();
            }
        }
    }

    public void postOrder(Visitable<T> visitable){
        postOrder(root,visitable);
    }

    private void postOrder(TreeNode<T> node, Visitable<T> visitable){
        if(node == null) return;

        postOrder(node.left,visitable);
        postOrder(node.right,visitable);
        visitable.visit(node);
    }

    public void postOrderWithoutRecursion(Visitable<T> visitable){
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode<T> current = stack.peek();

            if(current.isLeaf()){
                TreeNode<T> node = stack.pop();
                visitable.visit(node);
            }
            else{
                if(current.getRight() != null){
                    stack.push(current.getRight());
                    current.setRight(null);
                }

                if(current.getLeft() != null){
                    stack.push(current.getLeft());
                    current.setLeft(null);
                }
            }
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public interface Visitable<T> {
        void visit(TreeNode<T> node);
    }
}
