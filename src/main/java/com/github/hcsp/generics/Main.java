package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
        inorderRec(root, list::add);
        return list;
    }

    /**
     * 辅助中序遍历的方法，以递归方式调用
     *
     * @param node 二叉树节点
     * @param consumer 消费当前二叉树节点存储的数据
     * @param <T> 二叉树中实际存储的数据类型
     */
    public static <T> void inorderRec(BinaryTreeNode<T> node, Consumer<T> consumer) {
        if (node != null) {
            inorderRec(node.left, consumer);
            consumer.accept(node.value);
            inorderRec(node.right, consumer);
        }
    }
}
