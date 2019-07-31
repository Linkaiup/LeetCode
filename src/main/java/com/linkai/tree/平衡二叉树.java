package com.linkai.tree;

/**
 * @ClassName: 平衡二叉树
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-31 下午10:19
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(TreeDepth(root.left)-TreeDepth(root.right))<=1&&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left>right)?(left+1):(right+1);
    }
}
