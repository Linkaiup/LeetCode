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
            //拿右节点
            TreeNode pRight = node.right;
            //循环往下找最左节点
            while (pRight.left!=null)
                pRight = pRight.left;
            next = pRight;
        }else if (node.parent!=null){
            //往上找父节点
            TreeNode pCurrent = node;
            TreeNode pParent = node.parent;
            //需要把右子节点都访问一遍，往上找那个点
            while (pParent!=null&&pCurrent==pParent.right){
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            next = pParent;
        }
        return next;
    }
}
