package com.linkai.tree;

/**
 * @ClassName: GetNextNode
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-15 下午6:14
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class GetNextNode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { this.val = x; }
    }
    public static TreeNode getNextNode(TreeNode node){
        if (node==null)
            return null;
        TreeNode next=new TreeNode(0);
        if (node.right!=null){
            TreeNode pRight = node.right;
            while (pRight.left!=null)
                pRight = pRight.left;
            next = pRight;
        }else if (node.parent!=null){
            TreeNode pCurrent = node;
            TreeNode pParent = node.parent;
            while (pParent!=null&&pCurrent==pParent.right){
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            next = pParent;
        }
        return next;
    }
}
