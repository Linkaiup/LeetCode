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
    public class ListNode {
        int val;
        ListNode next;
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
}
