package com.linkai.dataStruct;
/**
 * @ClassName: ArrayListCopy
 * @Description: 复制复杂链表
 * @Author: K LIn
 * @Date: 19-3-28 下午7:09
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class ArrayListCopy {
    static class RandomListNode{
        private int lable;
        private RandomListNode next;
        private RandomListNode randomListNode;
        public RandomListNode(int lable){
            this.lable = lable;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode currentNode = pHead;
        //1.复制每个节点
        while (currentNode!=null){
            RandomListNode clone = new RandomListNode(currentNode.lable);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = clone;
            clone.next = nextNode;
            currentNode = nextNode;
        }
        currentNode = pHead;
        //2.再遍历，复制老节点的随机指针给新节点
        while (currentNode!=null){
            currentNode.next.randomListNode = currentNode.randomListNode==null?null:currentNode.randomListNode.next;
            currentNode = currentNode.next.next;
        }
        //3.拆分链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode!=null){
            RandomListNode clone = currentNode.next;
            currentNode.next = clone.next;
            clone.next = clone.next==null?null:clone.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}
