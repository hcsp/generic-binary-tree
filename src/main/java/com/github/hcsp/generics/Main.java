package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    public static <T> void traverseNode(BinaryTreeNode<T> root, List<T> result) {
        Stack<BinaryTreeNode<T>> nodeStack = new Stack<>();
        BinaryTreeNode<T> p = root;

        while (p != null || !nodeStack.isEmpty()) {
            while (p != null) {
                nodeStack.push(p);
                p = p.left;
            }
            BinaryTreeNode<T> cur = nodeStack.pop();
            result.add(cur.value);
            p = cur.right;
        }

    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();

        traverseNode(root, result);
        return result;
    }
}
