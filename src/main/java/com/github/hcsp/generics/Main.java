package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        return indorderTraversalMethod(root, result);

    }

    private static <T> List<T> indorderTraversalMethod(BinaryTreeNode<T> root, List<T> result) {

        if (root != null) {
            indorderTraversalMethod(root.left, result);
            result.add(root.value);
            indorderTraversalMethod(root.right, result);
        }
        return result;
    }
}
