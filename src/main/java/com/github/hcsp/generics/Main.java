package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

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
