package com.linkai.tree;

import java.util.ArrayList;

/**
 * @ClassName: FindTreePath
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-15 下午8:35
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class FindTreePath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { val = x; }
    }
    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode node,int target){
        if (node==null)
            return listAll;
        list.add(node.val);
        target-=node.val;
        if (target==0 && node.left==null && node.right==null)
            listAll.add(new ArrayList<>(list));
        findPath(node.left,target);
        findPath(node.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}
