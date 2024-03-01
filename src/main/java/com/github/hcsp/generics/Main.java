package com.github.hcsp.generics;

import java.util.*;

public class Main {

    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其泛型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        //非递归形式
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.value);
            root = root.right;
        }
        return result;
    }

}
