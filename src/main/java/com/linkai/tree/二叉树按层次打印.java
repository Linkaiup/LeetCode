package com.linkai.tree;

import java.util.ArrayList;

/**
 * @ClassName: 二叉树按层次打印
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-6 上午11:26
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 二叉树按层次打印 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot==null)
            return null;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        addCore(lists,1,pRoot);
        return lists;
    }
    private void addCore(ArrayList<ArrayList<Integer>> lists,int depth,TreeNode root){
        if (root==null)return;
        if (depth>lists.size())lists.add(new ArrayList<>());
        lists.get(depth-1).add(root.val);
        addCore(lists,depth+1,root.left);
        addCore(lists,depth+1,root.right);
    }
}
