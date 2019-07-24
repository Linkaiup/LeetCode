package com.linkai.tree;

/**
 * @author: lk
 * @date: 2019/7/23 15:24
 */
public class 二叉树的镜像 {
    public void Mirror(TreeNode root){
        if (root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left!=null)
                Mirror(root.left);
            if (root.right!=null)
                Mirror(root.right);
        }
    }
}
