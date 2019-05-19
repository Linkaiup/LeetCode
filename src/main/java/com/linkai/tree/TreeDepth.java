package com.linkai.tree;
/**
 * @ClassName: TreeDepth
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-16 上午9:31
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class TreeDepth {
    public int TreeDepth(TreeNode root){
        if (root==null)
            return 0;
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);

        return nLeft>nRight?(nLeft+1):(nRight+1);
    }
}
