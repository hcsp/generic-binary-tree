package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> list = new ArrayList<>();
        Deque<BinaryTreeNode<T>> deque = new LinkedList<>();
        BinaryTreeNode<T> node = root;

        while (node != null || !deque.isEmpty()) {
            // 先循环左子树，直到左子树为 null 时
            while (node != null) {
                deque.add(node);
                node = node.left;
            }

            // 从栈中拿出一个左子树，开始存值，并将该树的右子树赋值
            // 如果该树没有右子树，那将继续从栈中取，走这一步逻辑
            if (!deque.isEmpty()) {
                node = deque.pollLast();
                list.add(node.value);
                node = node.right;
            }
        }
        return list;
    }
}
