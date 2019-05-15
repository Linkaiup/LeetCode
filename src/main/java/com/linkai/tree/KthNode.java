package com.linkai.tree;

/**
 * @ClassName: KthNode
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-16 上午12:33
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class KthNode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { val = x; }
    }
    int count = 0;
    TreeNode KthNode(TreeNode pRoot,int k){
        if (pRoot==null||k<=0){
            return null;
        }
        TreeNode target = null;
        if (pRoot.left!=null){
            target = KthNode(pRoot.left,k);
        }
        count++;
        if (target==null){
            if (count==k){
                target = pRoot;
                return target;
            }
        }
        if (target==null&&pRoot.right!=null){
            target=KthNode(pRoot.right,k);
        }
        return target;
    }
}
