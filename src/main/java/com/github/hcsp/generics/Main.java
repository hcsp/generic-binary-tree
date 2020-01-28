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

    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其范型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T extends Comparable> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> values = new ArrayList<>();

        Stack<BinaryTreeNode<T>> nodeStack = new Stack<>();

        BinaryTreeNode<T> node = root;
        while (node != null || !nodeStack.isEmpty()){

            if (node != null){
                nodeStack.push(node);
                node = node.left;
            } else {
                node = nodeStack.pop();
                values.add(node.value);
                node = node.right;
            }

        }

        return values;
    }
}
