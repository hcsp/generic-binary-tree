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
    // 递归中序遍历：
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> resultList = new ArrayList<>();
        BinaryTreeNode<T> node = root;
        reTraversal(root, resultList);
        return resultList;
    }

    private static <T> void reTraversal(BinaryTreeNode<T> root, List<T> resultList) {
        if (root != null) {
            reTraversal(root.left, resultList);
            resultList.add(root.value);
            reTraversal(root.right, resultList);
        }
    }

    // 非递归中序遍历：
//    public static <T> List<T> inorderTraversal2(BinaryTreeNode<T> root) {
//        List<T> resultList = new ArrayList<>();
//        Stack<BinaryTreeNode<T>> stack = new Stack<>();
//        BinaryTreeNode<T> tempRoot = root;
//        while (tempRoot != null || !stack.isEmpty()) {
//            while (tempRoot != null) {
//                stack.push(tempRoot);
//                tempRoot = tempRoot.left;
//            }
//            tempRoot = stack.pop();
//            resultList.add(tempRoot.value);
//            tempRoot = tempRoot.right;
//        }
//        return resultList;
//    }
}
