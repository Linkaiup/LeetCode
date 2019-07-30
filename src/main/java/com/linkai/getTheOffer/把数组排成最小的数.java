package com.linkai.getTheOffer;

import java.util.PriorityQueue;

/**
 * @author: lk
 * @date: 2019/7/26 17:05
 */
public class 把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length==0)
            return "";
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(numbers.length,(o1, o2) -> (String.valueOf(o1)+String.valueOf(o2)).compareTo(String.valueOf(o2)+String.valueOf(o1)));
        for (Integer num:numbers){
            priorityQueue.add(num);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            stringBuilder.append(""+priorityQueue.poll());
        }
        return stringBuilder.toString();
    }
}
