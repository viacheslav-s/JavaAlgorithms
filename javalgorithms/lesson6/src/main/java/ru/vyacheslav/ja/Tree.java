package ru.vyacheslav.ja;

import java.util.ArrayList;

public class Tree {
    private class TreeNode {
        int payload;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.payload = value;
        }

        @Override
        public String toString() {
            return "(" + payload + ")";
        }
    }

    private TreeNode root;

    Tree(ArrayList<Integer> vals) {
        for (int i : vals)
            this.insert(i);
    }

    public void insert(int number) {
        TreeNode node = new TreeNode(number);
        if (root == null)
            root = node;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (number <= current.payload) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    boolean isBalanced(boolean precision) {
        int l = countDepth(root.left);
        int r = countDepth(root.right);
        System.out.printf("L=%03d, R=%03d\n", l, r);
        return Math.abs(l - r)
                <= ((precision) ? 0 : 1);
    }

    private int countDepth(TreeNode node) {
        if (node == null) return 0;

        int left = 0;
        int right = 0;

        if (node.left != null)
            left = countDepth(node.left);

        if (node.right != null)
            right = countDepth(node.right);

        return 1 + ((left > right) ? left : right);
    }

    public void displayTree() {
        inOrderTravers(root);
    }

    private void inOrderTravers(TreeNode node) {
        if (node != null) {
            inOrderTravers(node.left);
            System.out.println(node);
            inOrderTravers(node.right);
        }
    }
}
