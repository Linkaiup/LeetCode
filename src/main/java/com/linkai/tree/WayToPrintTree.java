package com.linkai.tree;

/**
 * @ClassName: WayToPrintTree
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-13 下午7:19
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class WayToPrintTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void prePrintTree(TreeNode node){
        if (node!=null) {
            System.out.println(node.val);
            prePrintTree(node.left);
            prePrintTree(node.right);
        }
    }
    public static void inPrintTree(TreeNode node){
        if (node!=null) {
            inPrintTree(node.left);
            System.out.println(node.val);
            inPrintTree(node.right);
        }
    }
    public static void posPrintTree(TreeNode node){
        if (node!=null){
            posPrintTree(node.left);
            posPrintTree(node.right);
            System.out.println(node.val);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        prePrintTree(root);
    }
}
