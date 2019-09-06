package com.linkai.medium.submit024;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-12-3 下午7:56
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // D->1->2->3->4

        ListNode curr = head; // 1
        ListNode prev = dummy; // D
        while (curr != null && curr.next != null) {//3
            ListNode next = curr.next; // 2  4

            curr.next = next.next; // 1->3 3->null
            next.next = curr;// 2->1 4->3
            prev.next = next; // D->2 1->4

            prev = curr; // 1 3
            curr = curr.next; //3 null
        }

        return dummy.next; //head
    }

    public static void main(String[] args) {
        int n = 8;
        int temp = n*2;
        //项数
        int fir=2;
        //首加末
        int sec=3;
        //判断是不是左起:0右起，1左起
        int flag=0;
        for (;fir*sec<temp;){
            fir++;
            sec++;
        }
        fir-=1;
        sec-=1;
        if (fir%2==1){
            flag=1;
        }
        n = n-(fir*sec/2);
        int row,lie;
        if (flag==1){
            row = sec-n+1;
            lie = n;
        }else {
            row = n;
            lie = sec-n+1;
        }
        System.out.println(row + " " + lie);
    }
}
