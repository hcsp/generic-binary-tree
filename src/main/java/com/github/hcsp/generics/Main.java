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

    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其泛型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果

    //非递归
//    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
//        Stack<BinaryTreeNode<T>> stack = new Stack<>();
//        ArrayList<T> result = new ArrayList<>();
//        BinaryTreeNode<T> node = root;
//        do {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            result.add(node.value);
//            node = node.right;
//        } while (!stack.isEmpty() || node != null);
//        return result;
//    }

    //递归
    public static <T> void inorderTraversalRecursion(BinaryTreeNode<T> node, List<T> result) {
        if (node.left != null) {
            inorderTraversalRecursion(node.left, result);
        }
        result.add(node.value);
        if (node.right != null) {
            inorderTraversalRecursion(node.right, result);
        }
    }

    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        ArrayList<T> result = new ArrayList<>();
        inorderTraversalRecursion(root, result);
        return result;
    }
}
