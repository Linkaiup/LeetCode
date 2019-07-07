package com.linkai.easy;

/**
 * @author K Lin
 * Date: 2019/4/19.
 * Time: 14:47
 * Remember to sow in the spring.
 * Description :
 */
public class ListNodeR {
    static class Node{
        //节点值
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node = initListNode(10);
        printListNode(node);
        node = reverseListNode(node);
        System.out.println("-----------");
        printListNode(node);
    }

    private static Node initListNode(int num) {
        Node head = new Node(1, null);
        Node now = head;
        for(int i=2; i<num;i++){
            now.next = new Node(i, null);
            now = now.next;
        }
        return head;
    }

    private static void printListNode(Node head) {
        Node node = head;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    private static Node reverseListNode(Node head) {
        if (head == null || head.next==null) {
            return head;
        }

        Node prev = null;
        Node next = null;
        while(head.next!=null){
            //保存下一个节点
            next = head.next;
            //重置next
            head.next = prev;
            //保存当前节点
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }
}
