package com.linkai.medium.submit039;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-2-8 下午3:09
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    static class ListNode{
        int value;
        ListNode next;
    }

    public static void reserve(ListNode head){
        if(head==null){
            return;
        }else{
            ListNode preNode = head;
            ListNode nowNode = head;
            ListNode nextNode = head.next;
            while(nextNode!=null){
                nowNode = nextNode;
                nextNode = nowNode.next;
                nowNode.next = preNode;
                preNode = nowNode;
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListNode nodeList = new ListNode();
        nodeList.value=1;
        for(int i =0;i<6;i++){
            nodeList.next=new ListNode();
            nodeList.value=i;
        }
        while(nodeList!=null){
            System.out.println(nodeList.value);
            nodeList=nodeList.next;
        }
        reserve(nodeList);
        while(nodeList!=null) {
            System.out.println(nodeList.value);
            nodeList = nodeList.next;
        }

    }
}
