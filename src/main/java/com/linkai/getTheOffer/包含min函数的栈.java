package com.linkai.getTheOffer;

import java.util.Stack;

/**
 * @author: lk
 * @date: 2019/7/24 17:19
 */
public class 包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();
    public void push(int node) {
        if (stackMin.empty()||node<min()){
            stackMin.push(node);
        }else if(node>min()){
            stackMin.push(min());
        }
        stack.push(node);
    }

    public void pop() {
        if (!stack.empty()){
            stack.pop();
            stackMin.pop();
        }
    }

    public int top() {
        if (!stack.empty()){
            stack.peek();
        }
        return 0;
    }

    public int min() {
        if (!stackMin.empty()){
            return stackMin.peek();
        }
        return 0;
    }
}
