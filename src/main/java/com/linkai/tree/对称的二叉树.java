package com.linkai.tree;

/**
 * @ClassName: 对称的二叉树
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-6 上午11:08
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 对称的二叉树 {
    boolean isSymmetrical(TreeNode node){
        if (node==null)
            return true;
        return comRoot(node.left,node.right);
    }
    private boolean comRoot(TreeNode left,TreeNode right){
        if (left==null)return right==null;
        if (right==null)return false;
        if (left.val!=right.val)return false;
        return comRoot(left.right,right.left)&&comRoot(left.left,right.right);
    }
}
