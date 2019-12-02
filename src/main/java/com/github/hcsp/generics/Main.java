package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class IntBinaryTreeNode {
        int value;
        IntBinaryTreeNode left;
        IntBinaryTreeNode right;
    }

    static class StringBinaryTreeNode {
        String value;
        StringBinaryTreeNode left;
        StringBinaryTreeNode right;
    }

    static class DoubleBinaryTreeNode {
        double value;
        DoubleBinaryTreeNode left;
        DoubleBinaryTreeNode right;
    }

    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其范型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void main(String[] args) {
        Main.BinaryTreeNode<Integer> node1 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node2 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node3 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node4 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node5 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node6 = new Main.BinaryTreeNode<>();

        {
            node1.value = 1;
            node2.value = 2;
            node3.value = 3;
            node4.value = 4;
            node5.value = 5;
            node6.value = 6;

            node1.left = node2;
            node1.right = node3;

            node2.left = node4;
            node2.right = node5;

            node3.right = node6;
        }
        inorderTraversal(node1);
    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.value);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
