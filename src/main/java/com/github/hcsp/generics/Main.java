package com.github.hcsp.generics;

import java.util.Stack;
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
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    private static List<Object> result = new ArrayList<>();

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
    /*
        // 中序遍历
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        result.add(root.value);
        inorderTraversal(root.right);

        return (List<T>) result;*/
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    result.add(root.value);
                    root = root.right;
                }
            }
        }
        return (List<T>) result;
    }
}
