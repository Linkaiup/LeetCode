package com.linkai.getTheOffer.链表;

/**
 * @ClassName: 删除链表的重复节点
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-6 上午10:34
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 删除链表的重复节点 {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)
            return pHead;
        int myFirst = -1;
        if (myFirst==pHead.val)
            myFirst = -2;
        ListNode head = new ListNode(myFirst);
        head.next = pHead;
        ListNode p = head;
        ListNode q = head.next;
        while (q!=null){
            while (q.next!=null&&q.next.val==q.val){
                q = q.next;
            }
            if (p.next != q){
                q=q.next;
                p.next=q;
            } else {
              p=q;
              q=q.next;
            }
        }
        return head.next;
    }
}
