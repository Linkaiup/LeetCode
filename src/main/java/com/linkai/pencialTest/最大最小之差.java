package com.linkai.pencialTest;

import java.util.PriorityQueue;

/**
 * @ClassName: 最大最小之差
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-28 下午9:04
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 最大最小之差 {
    public static void main(String[] args) {
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(20);
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(20,(o1, o2) -> o2-o1);

    }
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
