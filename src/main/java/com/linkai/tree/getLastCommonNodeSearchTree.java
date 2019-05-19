package com.linkai.tree;

/**
 * @ClassName: getLastCommonNodeSearchTree
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-17 下午1:34
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class getLastCommonNodeSearchTree {

    public static TreeNode getLastCommon(TreeNode root,TreeNode node1,TreeNode node2){
        TreeNode treeNode = null;
        if (root==null||node1.val>node2.val)
            return null;
        if (root.val>=node2.val){
            treeNode = getLastCommon(root.left,node1,node2);
        }else if (root.val<=node1.val){
            treeNode = getLastCommon(root.right,node1,node2);
        }else if (root.val>=node1.val&&root.val<=node2.val){
            return root;
        }
        return treeNode;
    }
}
