package com.linkai.tree;

/**
 * @ClassName: TreeToList
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-15 下午9:18
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class TreeToList {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { val = x; }
    }
    static TreeNode head = null;
    static TreeNode realHead = null;

    private static void ConvertNode(TreeNode pRoot){
        if (pRoot==null)
            return;
        ConvertNode(pRoot.left);
        if (head==null){
            head=pRoot;
            realHead=pRoot;
        }else {
            head.right = pRoot;
            pRoot.left = head;
            head=pRoot;
        }
        ConvertNode(pRoot.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        TreeNode newNode = ConvertNode(root);
        System.out.println(newNode.val+"+"+newNode.right.val);
    }
}
