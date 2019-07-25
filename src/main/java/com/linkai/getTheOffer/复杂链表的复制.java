package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/7/25 10:38
 */
public class 复杂链表的复制 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //具体操作一画图就很容易
        while (pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            //先连后
            node.next = pCur.next;
            //再连前
            pCur.next = node;
            //最后通过已连成功的新结点进行复制
            pCur = node.next;
        }
        pCur = pHead;
        while (pCur!=null){
            //对随机结点进行赋值
            if (pCur.random!=null)
                pCur.next.random=pCur.random.next;
            pCur=pCur.next.next;
        }
        pCur = pHead;
        //要返回，所以要新建结点
        //链表套路，必须保存头结点，下次可以继续使用或者最终可以返回
        RandomListNode head = pCur.next;
        //用一个指针去遍历链表
        RandomListNode cur = head;
        while (pCur!=null){
            pCur.next = pCur.next.next;
            if (cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }
}
