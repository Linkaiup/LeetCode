package com.linkai.easy.submit021;

/**
 * @author K Lin
 * Date: 2018/7/10.
 * Time: 07:59
 * Remember to sow in the spring.
 * Description :
 */
public class Solution {
    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
    /**
     * leetcode 大神细思极恐的操作
     */
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if(l1 == null) return l2;
         if(l2 == null) return l1;
         if(l1.val < l2.val){
             l1.next = mergeTwoLists(l1.next, l2);
             return l1;
         } else{
             l2.next = mergeTwoLists(l1, l2.next);
             return l2;
         }
    }
}
