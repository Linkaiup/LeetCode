package com.linkai.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName: FlipTree
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-13 下午5:41
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class FlipTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void flipTree(TreeNode node){
        if (node==null)
            return;
        if (node.left==null&&node.right==null)
            return;
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        if (node.left!=null)
            flipTree(node.left);
        if (node.right!=null)
            flipTree(node.right);
    }

    public static void printTree(TreeNode node){
        if (node==null)
            return;
        Queue queue = new LinkedBlockingDeque();
        ((LinkedBlockingDeque) queue).push(node);
        while (node!=null){
            if (node.left!=null)
                ((LinkedBlockingDeque) queue).addLast(node.left);
            if (node.right!=null)
                ((LinkedBlockingDeque) queue).addLast(node.right);
            System.out.println(node.val);
            ((LinkedBlockingDeque) queue).pop();
            node = (TreeNode) ((LinkedBlockingDeque) queue).peekFirst();
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        printTree(root);
        flipTree(root);
        printTree(root);
    }
}
