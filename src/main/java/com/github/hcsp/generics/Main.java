package com.github.hcsp.generics;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

  // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其泛型化，以节省代码
  static class BinaryTreeNode<T> {

    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

  }

  // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
  public static <T> List<T> inorderTraversal(BinaryTreeNode<T> root) {
    ArrayDeque<BinaryTreeNode<T>> deque = new ArrayDeque<>();
    BinaryTreeNode<T> node = root;
    List<T> list = new ArrayList<>();
    while (node != null || !deque.isEmpty()) { //最左子树
      while (node != null) {
        deque.add(node);
        node = node.left;
      }
      if (!deque.isEmpty()) {
        node = deque.pollLast(); //弹出左子树父亲
        list.add(node.value);
        node = node.right;
      }
    }
    return list;
  }
}

