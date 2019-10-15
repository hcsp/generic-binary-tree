package com.github.hcsp.generics;

import java.util.ArrayList;
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
        List<T> list = new ArrayList<>();
        inorderTraversal(list, root);
        return list;
    }

    private static <T> void inorderTraversal(List<T> list, BinaryTreeNode<T> root) {
        if (root != null) {
            inorderTraversal(list, root.left);
            list.add(root.value);
            inorderTraversal(list, root.right);
        }
    }
}
