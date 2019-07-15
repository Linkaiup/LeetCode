package com.linkai.getTheOffer;

import com.linkai.tree.TreeNode;

/**
 * @ClassName: RebuildTree
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-12 下午10:00
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class RebuildTree {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        Object o = new Object();
        o.hashCode();
        o.equals(o);
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    public TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        TreeNode root = new TreeNode(pre[startPre]);
        if (startPre == endPre&&startIn == endIn){
            return root;
        }
        int i = 0;
        for (i = startIn;i<endIn;i++){
            if (in[i]==pre[startPre]){
                break;
            }
        }
        int leftLength = i-startIn;
        int rightLength = endIn-i;
        if (leftLength>0)
            root.left = reConstructBinaryTree(pre,startPre+1,startPre+leftLength,in,startIn,i-1);
        if (rightLength>0)
            root.right = reConstructBinaryTree(pre,startPre+leftLength+1,endPre,in,i+1,endIn);
        return root;
    }
}
