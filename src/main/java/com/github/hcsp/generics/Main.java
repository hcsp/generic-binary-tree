package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> list = new ArrayList<>();
        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.value);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
}
