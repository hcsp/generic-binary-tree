package com.github.hcsp.generics;

import java.util.*;

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
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<T> target = new ArrayList<>();
        Set<BinaryTreeNode> set = new HashSet<>();
        if (root.right != null) {
            stack.push(root.right);
            set.add(root.right);
        }
        stack.push(root);
        set.add(root);
        while (stack.size() > 0) {
            BinaryTreeNode current = stack.get(stack.size() - 1);
            if (current.left != null && !set.contains(current.left)) {
                stack.push(current.left);
                set.add(current.left);
            } else {
                target.add((T) current.value);
                if (current.right != null && !set.contains(current.right)) {
                    set.add(current.right);
                    target.add((T) current.right.value);
                }
                stack.pop();
            }
        }
        return target;
    }

}
