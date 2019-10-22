package com.github.hcsp.generics;

import java.util.ArrayList;
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

    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其范型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 范型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> list = new ArrayList<>();
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }
                BinaryTreeNode<T> node = stack.pop();
                list.add(node.value);
                System.out.println(node.value);
                pNode = node.right;
        }
        return list;
    }
}
