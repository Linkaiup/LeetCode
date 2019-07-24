package com.linkai.getTheOffer;

import java.util.Stack;

/**
 * @author: lk
 * @date: 2019/7/24 19:26
 */
public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0||popA.length==0)
            return false;
        Stack<Integer> temp = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i=0;i<pushA.length;i++){
            //每次进一个
            temp.push(pushA[i]);
            //非空且相等才给
            while (!temp.empty()&&temp.peek()==popA[popIndex]){
                //记得pop
                temp.pop();
                popIndex++;
            }
        }
        return temp.empty();
    }
}
