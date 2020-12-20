package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其泛型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> results = new ArrayList<>();
        inorder(root, results);
        return results;
    }

    private static <T> void inorder(BinaryTreeNode<T> node, List<T> results) {
        if (node.left != null) {
            inorder(node.left, results);
        }
        results.add(node.value);
        if (node.right != null) {
            inorder(node.right, results);
        }
    }
}

