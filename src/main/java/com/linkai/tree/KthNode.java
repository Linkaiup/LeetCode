package com.linkai.tree;

import java.util.LinkedList;
import java.util.Queue;

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
    private static Queue<TreeNode> queue = new LinkedList<>();
    static void KthNode(Queue queue,TreeNode pRoot){
        if (pRoot!=null){
           KthNode(queue,pRoot.left);
           queue.add(pRoot);
           KthNode(queue,pRoot.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        KthNode(queue,root);
        for (int i = 1;i<=4;i++){
            queue.poll();
        }
        System.out.println(queue.poll().val);
        System.out.println(Math.floorMod(-4,11));

    }

}
