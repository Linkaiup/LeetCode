package com.linkai.getTheOffer.数组;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lk
 * @date: 2019/8/7 16:37
 */
public class 约瑟夫环 {
    public int LastRemaining_Solution(int n, int m) {
        Queue<Integer> children = new LinkedList<>();
        for (int i=0;i<n;i++){
            children.add(i);
        }
        if (children.size()==0)
            return -1;
        int count = 0;
        int child = 0;
        while (!children.isEmpty()){
            child = children.poll();
            count++;
            if (count%m!=0)
                children.add(child);
        }
        return child;
    }
}
