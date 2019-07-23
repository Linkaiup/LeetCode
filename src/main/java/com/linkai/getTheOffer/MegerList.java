package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/7/23 14:27
 */
public class MegerList {
    static class ListNode {
        private int value;
        private ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * return的为其链表头
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode megerList(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.value <= list2.value) {
            list1.next = megerList(list1.next, list2);
            return list1;
        } else {
            list2.next = megerList(list1, list2.next);
            return list2;
        }
    }
}
