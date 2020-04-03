package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    static class BinaryTreeNode<T extends Comparable<T>> {
        T value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果

    public static <T extends Comparable<T>> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        List<T> list = new ArrayList<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.value);
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return list;
    }
}
