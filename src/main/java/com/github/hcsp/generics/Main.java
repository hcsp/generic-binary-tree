package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    // 上面三种"二叉树节点"结构相似，内容重复，请将其泛型化，以节省代码
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return (List<T>) list;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {


            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            if (!stack.isEmpty()) {
                curNode = stack.pop();
                list.add((Integer) curNode.value);
                curNode = curNode.right;
            }
        }
        return (List<T>) list;
    }
}
