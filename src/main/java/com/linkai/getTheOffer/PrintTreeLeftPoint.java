package com.linkai.getTheOffer;

import com.linkai.tree.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName: PrintTreeLeftPoint
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-15 上午9:54
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class PrintTreeLeftPoint {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        node.left = node1;
        node.right = node2;
        node2.left = node5;
        printLeftPoint(node);
    }
    public static void printLeftPoint(TreeNode root){
        if (root==null)
            return;
        Queue queue = new LinkedBlockingDeque();
        ((LinkedBlockingDeque) queue).offer(root);
        int toBePrint = 1;
        int nextLevel = 1;
        while (!queue.isEmpty()){
            toBePrint=queue.size();
            TreeNode pNode = (TreeNode) queue.poll();
            if (toBePrint==nextLevel) {
                System.out.println(pNode.val);
                nextLevel=0;
                toBePrint--;
            }
            if (pNode.left!=null){
                ((LinkedBlockingDeque) queue).offer(pNode.left);
                nextLevel++;
            }
            if (pNode.right!=null){
                ((LinkedBlockingDeque) queue).offer(pNode.right);
                nextLevel++;
            }
        }
    }
}
