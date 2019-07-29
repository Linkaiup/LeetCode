package com.linkai.getTheOffer.链表;

/**
 * @ClassName: 两个链表的第一个公共节点
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-29 下午9:20
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 两个链表的第一个公共节点 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode pHead1Next = pHead1;
        ListNode pHead2Next = pHead2;
        int a = 0,b = 0;
        while (pHead1Next!=null){
            a++;
            pHead1Next=pHead1Next.next;
        }
        while (pHead2Next!=null){
            b++;
            pHead2Next=pHead2Next.next;
        }
        int dif = Math.abs(a-b);
        if (a > b) {
            for (int i =0;i<dif;i++){
                pHead1 = pHead1.next;
            }
            while (pHead1!=null){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead2;
        }else {
            for (int i =0;i<dif;i++){
                pHead2 = pHead2.next;
            }
            while (pHead2!=null){
                pHead2 = pHead2.next;
                pHead1 = pHead1.next;
            }
            return pHead1;
        }

    }
}
