package com.linkai.pencialTest;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName: 最小非零元素
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-20 下午9:17
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 最小非零元素 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        PriorityQueue<Long> priorityQueueIncreamt = new PriorityQueue<>(n);
        for (int i=0;i<n;i++){
            priorityQueueIncreamt.add(scanner.nextLong());
        }
        long count = 0;
        for (int i=0;i<k;i++){
            if (priorityQueueIncreamt.peek()==0){
                System.out.println(0);
                priorityQueueIncreamt.poll();
            }else {
                if ((priorityQueueIncreamt.peek() - count) != 0) {
                    System.out.println(priorityQueueIncreamt.peek() - count);
                    count += (priorityQueueIncreamt.poll() - count);
                } else {
                    priorityQueueIncreamt.poll();
                    i--;
                }
            }
        }
    }
}
