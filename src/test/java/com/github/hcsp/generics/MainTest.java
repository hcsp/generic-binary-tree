package com.github.hcsp.generics;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
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

    @Test
    public void test() {
        Assertions.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), Main.inorderTraversal(node1));
    }
}
