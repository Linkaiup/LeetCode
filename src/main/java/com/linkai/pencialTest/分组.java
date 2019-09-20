package com.linkai.pencialTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName: 分组
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-20 下午8:32
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 分组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arrays = new long[n*2];
        int index =0;
        for (int i=0;i<n;i++){
            int length = scanner.nextInt();
            int[] array = new int[length];
            for (int j=0;j<length;j++){
                array[j]=scanner.nextInt();
            }
            PriorityQueue<Integer> priorityQueueIncreamt = new PriorityQueue<Integer>(length/2);
            PriorityQueue<Integer> priorityQueueDown = new PriorityQueue<Integer>(length / 2, Comparator.reverseOrder());
            for (int j=0;j<length;j++){
                priorityQueueIncreamt.add(array[j]);
            }
            for (int j=0;j<length;j++){
                priorityQueueDown.add(array[j]);
            }

            long leftSum = 0,rightSum=0;
            for (int i1=0;i1<length/4;i1++){
                leftSum+=priorityQueueDown.poll();
                leftSum+=priorityQueueIncreamt.poll();
            }
            for (int i1=0;i1<length/4;i1++){
                rightSum+=priorityQueueDown.poll();
                rightSum+=priorityQueueIncreamt.poll();
            }
            if (length%2==1){
                Arrays.sort(array);
                int ifRight = (int) Math.abs(leftSum-rightSum);
                rightSum-=array[length/2];
                leftSum+=array[length/2];
                int ifLeft = (int)Math.abs(leftSum-rightSum);
                if (ifLeft>ifRight){
                    rightSum+=array[length/2];
                    leftSum-=array[length/2];
                }
            }
            if (leftSum<rightSum){
                arrays[index++]=leftSum;
                arrays[index++]=rightSum;
            }else {
                arrays[index++]=rightSum;
                arrays[index++]=leftSum;
            }
        }
        for (int i=0;i<arrays.length;i+=2){
            System.out.println(arrays[i]+" "+arrays[i+1]);
        }
    }
}
