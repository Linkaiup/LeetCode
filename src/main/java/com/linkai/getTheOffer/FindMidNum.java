package com.linkai.getTheOffer;

/**
 * @ClassName: FindMidNum
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-15 下午9:56
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class FindMidNum {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        insertList(0,root);
        System.out.println(root.next.next.next.val);
    }
    public static void insertList(int val,ListNode root){
        ListNode rootPre = new ListNode(0);
        ListNode newNode = new ListNode(val);
        while (root.next!=null){
            if (newNode.val>root.val){
                rootPre = root;
                root = root.next;
            }else if (newNode.val>=rootPre.val&&newNode.val<=root.val){
                newNode.next = root;
                if (rootPre.val!=0)
                    rootPre.next = newNode;
                break;
            }
        }
        if (root.next==null&&root.val<=newNode.val)
            root.next = newNode;
    }
}
