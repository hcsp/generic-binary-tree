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

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> list = new ArrayList<>();
        Stack<BinaryTreeNode<T>> binaryTreeStack = new Stack<>();
        BinaryTreeNode<T> treeNode = root;
        while (treeNode != null || !binaryTreeStack.isEmpty()) {
            while (treeNode != null) {
                binaryTreeStack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!binaryTreeStack.isEmpty()) {
                treeNode = binaryTreeStack.pop();
                list.add(treeNode.value);
                treeNode = treeNode.right;
            }
        }


        return list;
    }
}
