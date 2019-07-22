package com.linkai.getTheOffer;


/**
 * @author K Lin
 * Date: 2019/7/8.
 * Time: 21:37
 * Remember to sow in the spring.
 * Description :
 */
public class PrintListRever {
    static class ListNode{
        private int value;
        private ListNode next;
        public ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode newList(){
        ListNode listNode = new ListNode(1);
        ListNode listNext = listNode;

        for (int i = 2;i < 9;i++) {
            listNext.next = new ListNode(i);
            listNext = listNext.next;
        }
        return listNode;
    }
    public static void printList(ListNode listNode){
        if (listNode!=null){
            if (listNode.next!=null){
                printList(listNode.next);
            }
        }
        System.out.println(listNode.value);
    }

    public static void main(String[] args) {
        ListNode listHead = newList();
        printList(listHead);
    }

}
