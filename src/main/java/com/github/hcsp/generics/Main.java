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

        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    // 先递归左边，出栈添加元素再递归右边
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

    // 前序
    public static <T> List<T> inorderTraversal2(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        result.add(root.value);
        if (root.left != null) {
            result.addAll(inorderTraversal2(root.left));
        }
        if (root.right != null) {
            result.addAll(inorderTraversal2(root.right));
        }
        return result;
    }

    // 后序
    public static <T> List<T> inorderTraversal3(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(inorderTraversal3(root.left));
        }
        if (root.right != null) {
            result.addAll(inorderTraversal3(root.right));
        }
        result.add(root.value);
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>();
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
        System.out.println("中序: " + inorderTraversal(node1));
        System.out.println("前序: " + inorderTraversal2(node1));
        System.out.println("后序: " + inorderTraversal3(node1));
    }
}
