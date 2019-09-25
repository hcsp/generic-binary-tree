package com.github.hcsp.generics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其范型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> nodeList = new ArrayList<>();
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        BinaryTreeNode<T> treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                BinaryTreeNode<T> tailNode = stack.pop();
                nodeList.add(tailNode.value);
                treeNode = tailNode.right;
            }
        }
        return nodeList;
    }

    public static void main(String[] args) {
        Main.BinaryTreeNode<Integer> node1 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node2 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node3 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node4 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node5 = new Main.BinaryTreeNode<>();
        Main.BinaryTreeNode<Integer> node6 = new Main.BinaryTreeNode<>();

        {
            node1.value = 1;
            node2.value = 2;
            node3.value = 3;
            node4.value = 4;
            node5.value = 5;
            node6.value = 6;

            node1.left = node2;
            node1.right = node3;

            node2.left = node4;
            node2.right = node5;

            node3.right = node6;
        }
        inorderTraversal(node1);
    }
}
